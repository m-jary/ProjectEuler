package problem_54;

import java.util.HashMap;
import java.util.Map;

public class PokerHands {

    public static HashMap<Character, Integer> countCards(String hand) {
        HashMap<Character, Integer> countCards = new HashMap<>();

        for (char c : hand.toCharArray()) {
//            countCards.containsKey(c) ? countCards.put(c, countCards.get(c) + 1) : countCards.put(c, 1);
            if (countCards.containsKey(c)) {
                countCards.put(c, countCards.get(c) + 1);
            } else {
                countCards.put(c, 1);
            }
        }
        return countCards;
    }

    public static boolean hasOnePair(HashMap<Character, Integer> cards) {
        boolean hasOnePair = false;
        int pairCounter = 0;

        for (Map.Entry<Character,Integer> symbol : cards.entrySet()) {
            if (!symbol.getKey().equals('S') && !symbol.getKey().equals('H') && !symbol.getKey().equals('C') &&
                    !symbol.getKey().equals('D') && symbol.getValue() == 2) {
                pairCounter++;
            }
        }
        if (pairCounter == 1) {
            hasOnePair = true;
        }
        return hasOnePair;
    }

    public static boolean hasTwoPair(HashMap<Character, Integer> cards) {
        boolean hasTwoPair = false;
        int pairCounter = 0;

        for (Map.Entry<Character,Integer> symbol : cards.entrySet()) {
            if (!symbol.getKey().equals('S') && !symbol.getKey().equals('H') && !symbol.getKey().equals('C') &&
                    !symbol.getKey().equals('D') && symbol.getValue() == 2) {
                pairCounter++;
            }
        }
        if (pairCounter > 1) {
            hasTwoPair = true;
        }
        return hasTwoPair;
    }

    public static boolean hasThreeOfKind(HashMap<Character, Integer> cards) {
        boolean hasThreeOfKind = false;

        for (Map.Entry<Character,Integer> symbol : cards.entrySet()) {
            if (!symbol.getKey().equals('S') && !symbol.getKey().equals('H') && !symbol.getKey().equals('C') &&
                    !symbol.getKey().equals('D') && symbol.getValue() == 3) {
                hasThreeOfKind = true;
                break;
            }
        }
        return hasThreeOfKind;
    }

    public static boolean hasStraight(HashMap<Character, Integer> cards) {
        boolean hasStraight = false;

        if (cards.containsKey('A') && cards.containsKey('2') && cards.containsKey('3') && cards.containsKey('4') &&
                cards.containsKey('5')) {
            hasStraight = true;
        } else if (cards.containsKey('2') && cards.containsKey('3') && cards.containsKey('4') && cards.containsKey('5')
                && cards.containsKey('6')) {
            hasStraight = true;
        } else if (cards.containsKey('3') && cards.containsKey('4') && cards.containsKey('5') && cards.containsKey('6')
                && cards.containsKey('7')) {
            hasStraight = true;
        } else if (cards.containsKey('4') && cards.containsKey('5') && cards.containsKey('6') && cards.containsKey('7')
                && cards.containsKey('8')) {
            hasStraight = true;
        } else if (cards.containsKey('5') && cards.containsKey('6') && cards.containsKey('7') && cards.containsKey('8')
                && cards.containsKey('9')) {
            hasStraight = true;
        } else if (cards.containsKey('6') && cards.containsKey('7') && cards.containsKey('8') && cards.containsKey('9')
                && cards.containsKey('T')) {
            hasStraight = true;
        } else if (cards.containsKey('7') && cards.containsKey('8') && cards.containsKey('9') && cards.containsKey('T')
                && cards.containsKey('J')) {
            hasStraight = true;
        } else if (cards.containsKey('8') && cards.containsKey('9') && cards.containsKey('T') && cards.containsKey('J')
                && cards.containsKey('Q')) {
            hasStraight = true;
        } else if (cards.containsKey('9') && cards.containsKey('T') && cards.containsKey('J') && cards.containsKey('Q')
                && cards.containsKey('K')) {
            hasStraight = true;
        }
        return hasStraight;
    }

    public static boolean hasHighestStraight(HashMap<Character, Integer> cards) {
        return cards.containsKey('T') && cards.containsKey('J') && cards.containsKey('Q') && cards.containsKey('K') &&
                cards.containsKey('A');
    }

    public static boolean hasFlush(HashMap<Character, Integer> cards) {
        boolean hasFlush = false;

        for (Map.Entry<Character,Integer> symbol : cards.entrySet()) {
            if ((symbol.getKey().equals('S') || symbol.getKey().equals('H') || symbol.getKey().equals('C') ||
                    symbol.getKey().equals('D')) && symbol.getValue() == 5) {
                hasFlush = true;
                break;
            }
        }
        return hasFlush;
    }

    public static boolean hasFourOfKind(HashMap<Character, Integer> cards) {
        boolean hasFourOfKind = false;

        for (Map.Entry<Character,Integer> symbol : cards.entrySet()) {
            if (!symbol.getKey().equals('S') && !symbol.getKey().equals('H') && !symbol.getKey().equals('C') &&
                    !symbol.getKey().equals('D') && symbol.getValue() == 4) {
                hasFourOfKind = true;
                break;
            }
        }
        return hasFourOfKind;
    }

    public static int evaluateHand(HashMap<Character, Integer> cards) {
        int score = 0;

        if (hasHighestStraight(cards) && hasFlush(cards)) {
            System.out.println("Player has a Royal Flush.");
            score = 9;
        } else if (hasStraight(cards) && hasFlush(cards)) {
            System.out.println("Player has a Straight Flush.");
            score = 8;
        } else if (hasFourOfKind(cards)) {
            System.out.println("Player has a Four of a Kind.");
            score = 7;
        } else if (hasOnePair(cards) && hasThreeOfKind(cards)) {
            System.out.println("Player has a Full House.");
            score = 6;
        } else if (hasFlush(cards)) {
            System.out.println("Player has a Flush.");
            score = 5;
        } else if (hasStraight(cards)) {
            System.out.println("Player has a Straight.");
            score = 4;
        } else if (hasThreeOfKind(cards)) {
            System.out.println("Player has a Three of a Kind.");
            score = 3;
        } else if (hasTwoPair(cards)) {
            System.out.println("Player has a Two Pair.");
            score = 2;
        } else if (hasOnePair(cards)) {
            System.out.println("Player has a One Pair.");
            score = 1;
        } else {
            System.out.println("Player has a High Card.");
        }
        return score;
    }
}
