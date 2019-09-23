package scott_p3;

import java.util.Scanner;

public class rate {

    public static void main(String[] args) {

        int numberOfPeople = 0;
        int numberOfTopics = 5;
        int numberOfQuestions = 10;
        int currentRating = 0;

        Scanner scnr = new Scanner(System.in);
       // Array to store ratings
        int[][] ratingsArr = new int[numberOfTopics][numberOfQuestions];
        // Array to store topics
        String[] topics = new String[numberOfTopics];
        topics[0] = " Taco Tuesday";
        topics[1] = " Video games ";
        topics[2] = " TV          ";
        topics[3] = " Anime       ";
        topics[4] = " Topic 5     ";
        // Average Rating Array
        double averageRatingArr[] = new double[numberOfTopics];
        double sumRatingArr[] = new double[numberOfTopics];
        // Retrieve number of raterss
        System.out.print("How many people are rating the topics? ");

        numberOfPeople = scnr.nextInt();
        // Loop through raters
        for(int i = 0; i < numberOfPeople; i++) {
            System.out.print("Rate each of the topics between 1 and 10: \n");

            // Loop through questions
            for (int idx = 0; idx < numberOfTopics; idx++) {
                System.out.printf("What's your rating for %s?\n\t", topics[idx]);
                // Get next rating
                currentRating = scnr.nextInt();

                // Storing inputted array
                ratingsArr[idx][currentRating - 1] += 1;
            }
        }

        for (int topicIdx = 0; topicIdx < numberOfTopics; topicIdx++) {
            for (int questionIdx = 0; questionIdx < numberOfQuestions; questionIdx++) {
                averageRatingArr[topicIdx] += (ratingsArr[topicIdx][questionIdx] * (questionIdx+1));
            }
        }

        System.out.println();
        
        for (int topicIdx = 0; topicIdx < numberOfTopics; topicIdx++) {
            System.out.printf("%18s", (topicIdx+1));
        	System.out.print(topics[topicIdx]);
            for (int questionIdx = 0; questionIdx < numberOfQuestions; questionIdx++) {
                System.out.printf("%18s", ratingsArr[topicIdx][questionIdx]);
            }
            System.out.println();
        }

        System.out.print("Averages: \n");



        double max = averageRatingArr[0];

        int maxIndex = 0;
        for (int i = 0; i < numberOfTopics; i++)
        {
            if (max < averageRatingArr[i])
            {
                max = averageRatingArr[i];
                maxIndex = i;
            }
        }

        double min = averageRatingArr[0];

        int minIndex = 0;
        for (int i = 0; i < numberOfTopics; i++)
        {
            if (min > averageRatingArr[i])
            {
                min = averageRatingArr[i];
                minIndex = i;
            }
        }
        // Creates clone used for storing minimum and maximum array values
        sumRatingArr = averageRatingArr.clone();

        // Sets up the averageRatingArray to hold the average rating
        for (int i = 0; i < numberOfTopics; i++) {
            averageRatingArr[i] = averageRatingArr[i] / (double)numberOfPeople;
        }
        for (int idx = 0; idx < numberOfTopics; idx++) {
            System.out.printf("%18d%18f\n", (idx+1), averageRatingArr[idx]);
        }

        System.out.printf("Topic with most points: %f, \"%s\"\n", sumRatingArr[maxIndex], topics[maxIndex]);

        System.out.printf("Topic with least points: %f, \"%s\"\n", sumRatingArr[minIndex], topics[minIndex]);

    }
}