package com.insurancepolicymanagement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Manages insurance policies using HashMap, LinkedHashMap, and TreeMap.

class InsurancePolicyManager {
	// Declaring a HashMap to store policies with policy number as key
	private Map<String, InsurancePolicy> hashMap = new HashMap<>();

	// Declaring a LinkedHashMap to maintain insertion order
	private Map<String, InsurancePolicy> linkedHashMap = new LinkedHashMap<>();

	// Declaring a TreeMap to store policies sorted by expiry date
	private Map<LocalDate, InsurancePolicy> treeMap = new TreeMap<>();

	// Adds a policy to all maps ensuring proper storage and ordering.
	public void addPolicy(InsurancePolicy policy) {
		// Storing the policy in HashMap using policy number as key
		hashMap.put(policy.getPolicyNumber(), policy);

		// Storing the policy in LinkedHashMap to maintain insertion order
		linkedHashMap.put(policy.getPolicyNumber(), policy);

		// Storing the policy in TreeMap with expiry date as key to maintain sorted order
		treeMap.put(policy.getExpiryDate(), policy);
	}

	// Retrieves and displays a policy by its policy number.
	public void retrievePolicyByNumber(String policyNumber) {
		System.out.println("\nRetrieving Policy by Policy Number: " + policyNumber);

		// Checking if the policy exists in the HashMap
		if (hashMap.containsKey(policyNumber)) {
			// Printing the policy details if found in HashMap
			System.out.println(hashMap.get(policyNumber));
		} else {
			// Printing a message if policy is not found
			System.out.println("Policy not found.");
		}
	}

	// Lists all policies expiring within the next 30 days.

	public void listExpiringPolicies() {
		System.out.println("\nPolicies Expiring in the Next 30 Days:");

		// Getting the current date
		LocalDate today = LocalDate.now();

		// Iterating through the TreeMap to find policies expiring within 30 days
		for (Map.Entry<LocalDate, InsurancePolicy> entry : treeMap.entrySet()) {
			// Checking if the expiry date is within the next 30 days
			if (ChronoUnit.DAYS.between(today, entry.getKey()) <= 30) {
				// Printing the policy details if expiring within 30 days
				System.out.println(entry.getValue());
			}
		}
	}

	// Lists all policies belonging to a specific policyholder.

	public void listPoliciesByPolicyholder(String policyholderName) {
		System.out.println("\nPolicies for Policyholder: " + policyholderName);

		// Iterating through the HashMap to find policies matching the policyholder's name
		for (InsurancePolicy policy : hashMap.values()) {
			// Checking if the policyholder name matches the given name
			if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
				// Printing the policy details if it matches the policyholder's name
				System.out.println(policy);
			}
		}
	}

	// Removes all expired policies from all maps.

	public void removeExpiredPolicies() {
		System.out.println("\nRemoving Expired Policies:");

		// Getting the current date
		LocalDate today = LocalDate.now();

		// Creating a list to store expired policy numbers
		List<String> expiredPolicyNumbers = new ArrayList<>();

		// Iterating through the TreeMap to find expired policies
		for (Map.Entry<LocalDate, InsurancePolicy> entry : treeMap.entrySet()) {
			// Checking if the policy has already expired
			if (entry.getKey().isBefore(today)) {
				// Adding the expired policy number to the list
				expiredPolicyNumbers.add(entry.getValue().getPolicyNumber());
			}
		}

		// Removing expired policies from all maps
		for (String policyNumber : expiredPolicyNumbers) {
			// Removing the expired policy from HashMap using policy number
			hashMap.remove(policyNumber);

			// Removing the expired policy from LinkedHashMap using policy number
			linkedHashMap.remove(policyNumber);

			// Removing the expired policy from TreeMap using policy number
			treeMap.entrySet().removeIf(entry -> entry.getValue().getPolicyNumber().equals(policyNumber));

			// Printing the removed policy number
			System.out.println("Removed Policy No: " + policyNumber);
		}
	}

	// Displays all stored policies in insertion order using LinkedHashMap.
	public void displayAllPolicies() {
		System.out.println("\nAll Policies (Insertion Order):");

		// Iterating through the LinkedHashMap to maintain insertion order
		for (InsurancePolicy policy : linkedHashMap.values()) {
			// Printing the policy details in insertion order
			System.out.println(policy);
		}
	}
}