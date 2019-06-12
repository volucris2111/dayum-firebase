package com.projectdayum.dayum.customer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Component
public class CustomerDataAccess {

	private void convertCustomerList(final List<Customer> documents, final QuerySnapshot querySnapshot) {
		for (final QueryDocumentSnapshot document : querySnapshot.getDocuments()) {
			final ObjectMapper mapper = new ObjectMapper();
			final Customer customer = mapper.convertValue(document.getData(), Customer.class);
			customer.setId(document.getId());
			documents.add(customer);
		}
	}

	public List<Customer> getById(String id) {
		final List<Customer> documents = new LinkedList<>();
		try {
			final Firestore db = FirestoreClient.getFirestore();
			final ApiFuture<QuerySnapshot> query = db.collection("testcollection")
					.whereEqualTo(FieldPath.documentId(), id).get();
			final QuerySnapshot querySnapshot = query.get();
			this.convertCustomerList(documents, querySnapshot);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return documents;
	}

	public List<Customer> getByZip(String zip) {
		final List<Customer> documents = new LinkedList<>();
		try {
			final Firestore db = FirestoreClient.getFirestore();
			final ApiFuture<QuerySnapshot> query = db.collection("testcollection")
					.whereEqualTo(FieldPath.of("address", "zipCity", "zip"), zip).get();
			final QuerySnapshot querySnapshot = query.get();
			this.convertCustomerList(documents, querySnapshot);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return documents;
	}

	public List<Customer> getSomething() {
		final List<Customer> documents = new LinkedList<>();
		try {
			final Firestore db = FirestoreClient.getFirestore();
			final ApiFuture<QuerySnapshot> query = db.collection("testcollection").get();
			final QuerySnapshot querySnapshot = query.get();
			this.convertCustomerList(documents, querySnapshot);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return documents;
	}
	
	public String saveSomething() {
		final String id = null;
		final Customer customer = new Customer();
		customer.setFirstName("TESTER22");
		customer.setLastName("TESTIKUS22");
		final Address address = new Address();
		address.setStreet("TEST-STREET");
		address.setCity("TEST CITY");
		final ZipCity zipCity = new ZipCity();
		zipCity.setCity("TESTCITY");
		zipCity.setZip("54321");
		address.setZipCity(zipCity);
		customer.setAddress(address);
		final Firestore db = FirestoreClient.getFirestore();
		db.collection("testcollection").add(customer);
		return id;
	}

}
