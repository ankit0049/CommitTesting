package com.votingmanagementsystem;


import java.util.*;

 // Represents a voting system where votes are cast for candidates.
 // Uses HashMap, LinkedHashMap, and TreeMap to store and display votes.
class VotingSystem {
	// HashMap to store votes by candidate name
	private Map<String, Integer> votesHashMap = new HashMap<>();

	// LinkedHashMap to store votes maintaining the order in which votes were cast
	private Map<String, Integer> votesLinkedHashMap = new LinkedHashMap<>();

	// TreeMap to store votes and automatically sort them in ascending order of votes
	private Map<Integer, String> votesTreeMap = new TreeMap<>(Collections.reverseOrder());

	// Cast a vote for the candidate
	public void castVote(String candidateName) {
		// Check if the candidate is already in the HashMap
		if (votesHashMap.containsKey(candidateName)) {
			// If the candidate exists, increment the vote count in all maps
			votesHashMap.put(candidateName, votesHashMap.get(candidateName) + 1);
			votesLinkedHashMap.put(candidateName, votesLinkedHashMap.get(candidateName) + 1);
		} else {
			// If the candidate is new, add them with 1 vote
			votesHashMap.put(candidateName, 1);
			votesLinkedHashMap.put(candidateName, 1);
		}

		// Update the TreeMap to maintain the vote count in sorted order
		votesTreeMap.put(votesHashMap.get(candidateName), candidateName);
	}

	// Displays all votes in the order in which they were cast using LinkedHashMap.
	public void displayVotesInOrder() {
		System.out.println("\nVotes in Order (LinkedHashMap):");
		for (Map.Entry<String, Integer> entry : votesLinkedHashMap.entrySet()) {
			System.out.println("Candidate: " + entry.getKey() + ", Votes: " + entry.getValue());
		}
	}

	// Displays the results sorted by vote count using TreeMap.
	public void displayResultsSortedByVotes() {
		System.out.println("\nResults Sorted by Votes (TreeMap):");
		for (Map.Entry<Integer, String> entry : votesTreeMap.entrySet()) {
			System.out.println("Candidate: " + entry.getValue() + ", Votes: " + entry.getKey());
		}
	}

	// Displays the total number of votes for each candidate using HashMap.
	public void displayTotalVotes() {
		System.out.println("\nTotal Votes (HashMap):");
		for (Map.Entry<String, Integer> entry : votesHashMap.entrySet()) {
			System.out.println("Candidate: " + entry.getKey() + ", Votes: " + entry.getValue());
		}
	}
}
