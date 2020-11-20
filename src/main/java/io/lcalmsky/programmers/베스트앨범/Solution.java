package io.lcalmsky.programmers.베스트앨범;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Song> songs = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            songs.add(new Song(i, genre, playCount));
            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + plays[i]);
        }
        Collections.sort(songs);

        List<String> genreList = genreMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Collections.reverse(genreList);

        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : genreList) {
            for (int i = 0, count = 0; i < songs.size(); i++) {
                Song song = songs.get(i);
                if (genre.equals(song.genre)) {
                    count++;
                    bestAlbum.add(song.id);
                }
                if (count == 2) break;
            }
        }

        int[] answer = new int[bestAlbum.size()];
        for (int i = 0; i < bestAlbum.size(); i++) {
            answer[i] = bestAlbum.get(i);
        }

        return answer;
    }

    public static class Song implements Comparable<Song> {
        private int id;
        private String genre;
        private int playCount;

        public Song(int id, String genre, int playCount) {
            this.id = id;
            this.genre = genre;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Song o) {
            return Integer.compare(o.playCount, this.playCount);
        }
    }
}
