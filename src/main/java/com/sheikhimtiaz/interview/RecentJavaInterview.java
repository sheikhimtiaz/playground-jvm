package com.sheikhimtiaz.interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RecentJavaInterview {


    public static void run() {
        System.out.println(smashTheBricks(0, Arrays.asList(2))); // [[2], [-1], [1]]
        System.out.println(smashTheBricks(4, Arrays.asList(3, 2, 5, 4, 6, 7, 9))); //   [[13], [3, 5, 6, 7], [1, 2, 4]]


        List<Integer> processSize = Arrays.asList(2, 5, 3);
        List<Integer> capacity = Arrays.asList(6, 2, 4);

        int result = getMinimumTime(processSize, capacity);
        System.out.println("Minimum time required: " + result); // Should output 1

        // Additional test case
        List<Integer> processSize2 = Arrays.asList(2, 5, 3, 4, 1);
        List<Integer> capacity2 = Arrays.asList(6, 2, 4);

        result = getMinimumTime(processSize2, capacity2);
        System.out.println("Minimum time required for second test: " + result);


        List<String> resultClubs = eliteClubs("England", 823472, 2);
        for (String club : resultClubs) {
            System.out.println(club);
        }
    }


    public static List<String> eliteClubs(String nation, int minValuation, int minTitlesWon) {
        List<String> result = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            // Get first page to determine total pages
            String baseUrl = "https://jsonmock.hackerrank.com/api/football_teams?nation=" + nation;
            JSONObject firstPage = makeApiRequest(baseUrl, parser);
            int totalPages = ((Long) firstPage.get("total_pages")).intValue();

            // Process all clubs across all pages
            List<Club> eligibleClubs = new ArrayList<>();
            for (int page = 1; page <= totalPages; page++) {
                String url = baseUrl + "&page=" + page;
                JSONObject response = makeApiRequest(url, parser);
                JSONArray data = (JSONArray) response.get("data");

                // Process each club in the current page
                for (Object obj : data) {
                    JSONObject club = (JSONObject) obj;
                    long value = (Long) club.get("estimated_value_numeric");
                    long titles = (Long) club.get("number_of_league_titles_won");
                    String name = (String) club.get("name");

                    if (value >= minValuation && titles >= minTitlesWon) {
                        eligibleClubs.add(new Club(name, value));
                    }
                }
            }

            // Sort clubs by valuation (descending) and name (ascending)
            Collections.sort(eligibleClubs, new Comparator<Club>() {
                @Override
                public int compare(Club c1, Club c2) {
                    if (c1.value != c2.value) {
                        return Long.compare(c2.value, c1.value);  // Descending order
                    }
                    return c1.name.compareTo(c2.name);  // Ascending order
                }
            });

            // Extract sorted club names
            for (Club club : eligibleClubs) {
                result.add(club.name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private static JSONObject makeApiRequest(String urlString, JSONParser parser) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return (JSONObject) parser.parse(response.toString());
    }

    // Helper class to store club information for sorting
    static class Club {
        String name;
        long value;

        Club(String name, long value) {
            this.name = name;
            this.value = value;
        }
    }

    public static int getMinimumTime(List<Integer> processSize, List<Integer> capacity) {
        int n = processSize.size();
        int m = capacity.size();

        // Create a list of processor assignments with their timelines
        List<List<Integer>> assignments = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            assignments.add(new ArrayList<>());
        }

        // Sort processes from largest to smallest for greedy approach
        List<Integer> processIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            processIndices.add(i);
        }
        Collections.sort(processIndices, (a, b) -> processSize.get(b) - processSize.get(a));

        // For each process, try to assign it to the processor that can complete it earliest
        for (int processIndex : processIndices) {
            int size = processSize.get(processIndex);
            int bestProcessor = -1;
            int earliestCompletion = Integer.MAX_VALUE;

            // Find the best processor for this process
            for (int i = 0; i < m; i++) {
                if (capacity.get(i) >= size) {
                    // Calculate when this processor would complete the process
                    int currentTime = assignments.get(i).isEmpty() ?
                            1 : // Just the process time
                            assignments.get(i).get(assignments.get(i).size() - 1) + 2; // Last completion + pause + process

                    if (currentTime < earliestCompletion) {
                        earliestCompletion = currentTime;
                        bestProcessor = i;
                    }
                }
            }

            // If no processor can handle this process, return -1
            if (bestProcessor == -1) {
                return -1;
            }

            // Assign the process to the best processor
            assignments.get(bestProcessor).add(earliestCompletion);
        }

        // Find the maximum completion time across all processors
        int maxTime = 0;
        for (List<Integer> processorTimes : assignments) {
            if (!processorTimes.isEmpty()) {
                maxTime = Math.max(maxTime, processorTimes.get(processorTimes.size() - 1));
            }
        }

        return maxTime;
    }



    public static int getMinimumTime2(List<Integer> processSize, List<Integer> capacity) {
        int n = processSize.size();
        int m = capacity.size();

        // Sort capacities in descending order for faster matching
        List<Integer> sortedCapacities = new ArrayList<>(capacity);
        Collections.sort(sortedCapacities, Collections.reverseOrder());

        // If largest capacity can't handle largest process, return -1 early
        int maxProcess = Collections.max(processSize);
        if (sortedCapacities.get(0) < maxProcess) {
            return -1;
        }

        // Keep track of current time for each processor
        PriorityQueue<Integer> processorTimes = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            processorTimes.add(0);
        }

        // Sort processes in descending order
        List<Integer> sortedProcesses = new ArrayList<>(processSize);
        Collections.sort(sortedProcesses, Collections.reverseOrder());

        // Process each task
        for (int size : sortedProcesses) {
            // Find a suitable processor
            boolean assigned = false;
            int earliestTime = processorTimes.poll();

            // Try to assign to processors with sufficient capacity
            for (int cap : sortedCapacities) {
                if (cap >= size) {
                    assigned = true;
                    // Add process time (1) plus pause time (1) if not starting from 0
                    processorTimes.offer(earliestTime + (earliestTime > 0 ? 2 : 1));
                    break;
                }
            }

            if (!assigned) {
                processorTimes.offer(earliestTime);  // Put back the time we took out
                return -1;
            }
        }

        // Return the maximum completion time
        int maxTime = 0;
        while (!processorTimes.isEmpty()) {
            maxTime = Math.max(maxTime, processorTimes.poll());
        }
        return maxTime;
    }

    public static List<List<Long>> smashTheBricks(int bigHits, List<Integer> newtons) {
        int n = newtons.size();

        // Create index-value pairs
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new int[]{i + 1, newtons.get(i)});
        }

        // Sort by newtons descending
        pairs.sort((a, b) -> b[1] - a[1]);

        List<Long> bigIndices = new ArrayList<>();
        List<Long> smallIndices = new ArrayList<>();
        long totalHits = 0;

        // Use big hammer on highest newton bricks
        for (int i = 0; i < n && i < bigHits; i++) {
            bigIndices.add((long)pairs.get(i)[0]);
            totalHits++;
        }

        // Use small hammer on remaining
        for (int i = bigHits; i < n; i++) {
            smallIndices.add((long)pairs.get(i)[0]);
            totalHits += pairs.get(i)[1];
        }

        // Sort indices ascending
        Collections.sort(bigIndices);
        Collections.sort(smallIndices);

        // Handle empty lists
        if (bigIndices.isEmpty()) bigIndices.add(-1L);
        if (smallIndices.isEmpty()) smallIndices.add(-1L);

        return Arrays.asList(
                Arrays.asList(totalHits),
                bigIndices,
                smallIndices
        );
    }
}
