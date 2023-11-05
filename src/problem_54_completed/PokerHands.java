package problem_54_completed;

import java.util.*;

public class PokerHands {
    public int p1Score;

    public PokerHands(String p1Hand, String p2Hand) {
        p1Score = handCompare(p1Hand, p2Hand);
    }

    public HashMap<Integer, Integer> countRanks(String hand) {
        HashMap<Integer, Integer> countRanks = new HashMap<>();
        for (int i = 0; i < hand.length(); i += 2) {
            char c = hand.charAt(i);
            int temp = switch (c) {
                case 'A' -> 14;
                case 'K' -> 13;
                case 'Q' -> 12;
                case 'J' -> 11;
                case 'T' -> 10;
                default -> c - '0';
            };
            if (countRanks.containsKey(temp)) {
                countRanks.put(temp, countRanks.get(temp) + 1);
            } else {
                countRanks.put(temp, 1);
            }
        }
        return countRanks;
    }

    public HashMap<Integer, Integer> countSuits(String hand) {
        HashMap<Integer, Integer> countSuits = new HashMap<>();
        for (int i = 1; i < hand.length(); i += 2) {
            char c = hand.charAt(i);
            int temp = switch (c) {
                case 'S' -> 4;
                case 'H' -> 3;
                case 'C' -> 2;
                case 'D' -> 1;
                default -> 0;
            };
            if (countSuits.containsKey(temp)) {
                countSuits.put(temp, countSuits.get(temp) + 1);
            } else {
                countSuits.put(temp, 1);
            }
        }
        return countSuits;
    }

    public boolean isFlush(HashMap<Integer, Integer> suits) {
        return suits.size() == 1;
    }

    public boolean isStraight(HashMap<Integer, Integer> ranks) {
        ArrayList<Integer> temp = new ArrayList<>(ranks.keySet());
        int counter = 0;
        for (int i = 0; i < temp.size() - 1; i++) {
            if (temp.get(i + 1) - temp.get(i) == 1) {
                counter++;
            }
        }
        return counter == 4;
    }

    public boolean isWheel(HashMap<Integer, Integer> ranks) {
        ArrayList<Integer> temp = new ArrayList<>(ranks.keySet());
        int counter = 0;
        if (temp.getLast() == 14 && temp.getFirst() == 2) {
            temp.removeLast();
            temp.removeFirst();
            for (int i = 0; i < temp.size() - 1; i++) {
                if (temp.get(i + 1) - temp.get(i) == 1) {
                    counter++;
                }
            }
        }
        return counter == 2;
    }

    public int kicker(HashMap<Integer, Integer> ranks) {
        ArrayList<Integer> temp = new ArrayList<>(ranks.keySet());
        return temp.getLast();
    }

    public boolean isFour(HashMap<Integer, Integer> ranks) {
        return ranks.containsValue(4);
    }

    public boolean isThree(HashMap<Integer, Integer> ranks) {
        return ranks.containsValue(3);
    }

    public int pairCounter(HashMap<Integer, Integer> ranks) {
        int counter = 0;
        for (Map.Entry<Integer,Integer> rank : ranks.entrySet()) {
            if (rank.getValue() == 2) {
                counter++;
            }
        }
        return counter;
    }

    public int evaluator(String hand) {
        HashMap<Integer, Integer> ranks = countRanks(hand);
        HashMap<Integer, Integer> suits = countSuits(hand);
        boolean flush = isFlush(suits);
        boolean straight = isStraight(ranks);
        boolean wheel = isWheel(ranks);
        boolean four = isFour(ranks);
        int kicker = kicker(ranks);
        int pairs = pairCounter(ranks);
        boolean three = isThree(ranks);

        if (straight && flush && kicker == 14 && !ranks.containsKey(2)) {
            System.out.println("Royal Flush");
            return 10;
        } else if (straight && flush && kicker != 14) {
            System.out.println("Straight Flush");
            return 9;
        } else if (four) {
            System.out.println("Four of a Kind");
            return 8;
        } else if (pairs == 1 && three) {
            System.out.println("Full House");
            return 7;
        } else if (flush) {
            System.out.println("Flush");
            return 6;
        } else if (straight) {
            System.out.println("Straight");
            return 5;
        } else if (wheel) {
            System.out.println("Wheel");
            return 4;
        } else if (three) {
            System.out.println("Three of a Kind");
            return 3;
        } else if (pairs == 2) {
            System.out.println("Two Pair");
            return 2;
        } else if (pairs == 1) {
            System.out.println("One Pair");
            return 1;
        } else {
            System.out.println("High Card");
            return 0;
        }
    }

    public int handCompare(String p1Hand, String p2Hand){
        int p1Score = evaluator(p1Hand);
        int p2Score = evaluator(p2Hand);
        int p1Wins = 0;

        if (p1Score > p2Score) {
            System.out.println("Player 1 wins!");
            p1Wins++;
        } else if (p1Score < p2Score) {
            System.out.println("Player 2 wins!");
        } else if (p1Score == 9 || p1Score == 6 || p1Score == 5 || p1Score == 0) {
            if (tieBreakerSF(p1Hand, p2Hand) == 1) {
                System.out.println("Player 1 wins!");
                p1Wins++;
            } else {
                System.out.println("Player 2 wins!");
            }
        } else if (p1Score == 7 || p1Score == 3) {
            if (tieBreakerFH(p1Hand, p2Hand) == 1) {
                System.out.println("Player 1 wins!");
                p1Wins++;
            } else {
                System.out.println("Player 2 wins!");
            }
        } else if (p1Score == 2 || p1Score == 1) {
            if (tieBreakerP(p1Hand, p2Hand) == 1) {
                System.out.println("Player 1 wins!");
                p1Wins++;
            } else {
                System.out.println("Player 2 wins!");
            }
        } else {
            System.out.println("Tie!");
        }
        return p1Wins;
    }

    public int tieBreakerSF(String p1Hand, String p2Hand) {
        HashMap<Integer, Integer> p1Ranks = countRanks(p1Hand);
        HashMap<Integer, Integer> p2Ranks = countRanks(p2Hand);
        ArrayList<Integer> p1Temp = new ArrayList<>(p1Ranks.keySet());
        ArrayList<Integer> p2Temp = new ArrayList<>(p2Ranks.keySet());
        int p1Wins = 0;

        for (int i = 0; i < p1Temp.size(); i++) {
            if (p1Temp.getLast() > p2Temp.getLast()) {
                p1Wins++;
                break;
            } else if (p1Temp.getLast() < p2Temp.getLast()) {
                break;
            } else {
                p1Temp.removeLast();
                p2Temp.removeLast();
            }
        }
        return p1Wins;
    }

    public int tieBreakerFH(String p1Hand, String p2Hand) {
        HashMap<Integer, Integer> p1Ranks = countRanks(p1Hand);
        HashMap<Integer, Integer> p2Ranks = countRanks(p2Hand);
        Set<Map.Entry<Integer, Integer>> p1Set = p1Ranks.entrySet();
        Set<Map.Entry<Integer, Integer>> p2Set = p2Ranks.entrySet();
        Iterator<Map.Entry<Integer, Integer>> p1Iterator = p1Set.iterator();
        Iterator<Map.Entry<Integer, Integer>> p2Iterator = p2Set.iterator();
        int p1Wins = 0;

        while (p1Iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = p1Iterator.next();
            int value = entry.getValue();
            if (value != 3) {
                p1Iterator.remove();
            }
        }
        while (p2Iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = p2Iterator.next();
            int value = entry.getValue();
            if (value != 3) {
                p2Iterator.remove();
            }
        }

        ArrayList<Integer> p1Temp = new ArrayList<>(p1Ranks.keySet());
        ArrayList<Integer> p2Temp = new ArrayList<>(p2Ranks.keySet());
        if (p1Temp.getFirst() > p2Temp.getFirst()) {
            p1Wins = 1;
        }
        return p1Wins;
    }

    public int tieBreakerP(String p1Hand, String p2Hand) {
        HashMap<Integer, Integer> p1Ranks = countRanks(p1Hand);
        HashMap<Integer, Integer> p2Ranks = countRanks(p2Hand);
        Set<Map.Entry<Integer, Integer>> p1Set = p1Ranks.entrySet();
        Set<Map.Entry<Integer, Integer>> p2Set = p2Ranks.entrySet();
        Iterator<Map.Entry<Integer, Integer>> p1Iterator = p1Set.iterator();
        Iterator<Map.Entry<Integer, Integer>> p2Iterator = p2Set.iterator();
        ArrayList<Integer> p1Kickers = new ArrayList<>();
        ArrayList<Integer> p2Kickers = new ArrayList<>();
        int p1Wins = 0;
        int noWinner = 0;

        while (p1Iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = p1Iterator.next();
            int value = entry.getValue();
            if (value != 2) {
                p1Kickers.add(entry.getKey());
                p1Iterator.remove();
            }
        }
        while (p2Iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = p2Iterator.next();
            int value = entry.getValue();
            if (value != 2) {
                p2Kickers.add(entry.getKey());
                p2Iterator.remove();
            }
        }

        ArrayList<Integer> p1Temp = new ArrayList<>(p1Ranks.keySet());
        ArrayList<Integer> p2Temp = new ArrayList<>(p2Ranks.keySet());
        for (int i = 0; i < p1Temp.size(); i++) {
            if (p1Temp.getLast() > p2Temp.getLast()) {
                p1Wins++;
                break;
            } else if (p1Temp.getLast() < p2Temp.getLast()) {
                break;
            } else {
                noWinner++;
                p1Temp.removeLast();
                p2Temp.removeLast();
            }
        }

        if ((noWinner == 2 && p1Ranks.size() == 2) || (noWinner == 1 && p1Ranks.size() == 1)) {
            Integer[] p1KickerArray = new Integer [p1Kickers.size()];
            p1KickerArray = p1Kickers.toArray(p1KickerArray);
            Integer[] p2KickerArray = new Integer [p2Kickers.size()];
            p2KickerArray = p2Kickers.toArray(p2KickerArray);
            for (int i = 0; i < p1KickerArray.length; i++) {
                if (p1KickerArray[i] > p2KickerArray[i]) {
                    p1Wins++;
                    break;
                } else if (p1KickerArray[i] < p2KickerArray[i]) {
                    break;
                }
            }
        }
        return p1Wins;
    }
}
