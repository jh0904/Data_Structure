package day06_SetAndHash;

import java.util.ArrayList;

/**
 * day06_SetAndHash
 *
 * @author jh
 * @date 2018/8/7 10:02
 * description:对LinkedListMap的测试
 */
public class LinkedListMapTest {
	public static void main(String[] args){

		System.out.println("Pride and Prejudice");

		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile("C:\\Users\\jh\\IdeaProjects\\Data_Structure\\src\\day06_SetAndHash\\pride-and-prejudice.txt", words)) {
			System.out.println("Total words: " + words.size());

			LinkedListMap<String, Integer> map = new LinkedListMap<>();
			for (String word : words) {
				if (map.contains(word))
					map.set(word, map.get(word) + 1);
				else
					map.add(word, 1);
			}

			System.out.println("Total different words: " + map.getSize());
			System.out.println("Frequency of PRIDE: " + map.get("pride"));
			System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
		}

		System.out.println();
	}
}
