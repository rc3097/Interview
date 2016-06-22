package uber;

import java.awt.image.RescaleOp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.stream.events.StartDocument;

import microsoft.SubArrayMax;

/*
 * 第二轮，国人大哥。怎么从一个source file里读出comment并保存。类似保存或打印出代码里的comment。包括要打印单行或者多行的情况。 可以compile并输出结果，所以还是比较有说服力。自己写输入输出的类型。感谢国人大哥防水。
 比如：
 This is code. // comment1
 This is code.
 /*
 print
 me.
 out.
 单行情况，寻找//, java我直接调用的indexOf("//")， 保存后面的substring。多行的情况寻找和  pair, 保存中间的substring。我的输入是一个string，所以prototype是 public static ArrayList<String> getComments(String str).
 假设就是把一个文件全都读到一个长的string里。memory肯定存在不够用的情况。follow up是如果不仅要输出comments,还要输出comments所在的行数，没有具体实现，就是说了说。我的情况就要保存每个的行数了，肯定很繁琐。所以回到开始的问题。因为没有给定函数的输入是什么，所以最好的情况还是把File当成输入，每次读一行，所以行数就很好保存了

 第二题MS onsite也问过，不过没写代码，你忘了考虑string里包含"//"及"/*..的情况了。.湴
 比如 String s = "//this is not a comment"; 你的code会多输出这个。这只是个例子，当时ms的面试官说还有很多种corner case。
 */
public class Comments {

	public ArrayList<String> getComments(String s) {
		ArrayList<String> res = new ArrayList<String>();
		int singlequote = 0;
		int doublequote = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '\'')
				singlequote++;
			else if (s.charAt(i) == '"')
				doublequote++;
			else if (i + 1 < s.length() && singlequote % 2 == 0
					&& doublequote % 2 == 0 && s.charAt(i) == '/') {
				if (s.charAt(i + 1) == '/') {
					start = i;
					int end = s.indexOf("\n", start);
					if (end == -1)
						end = s.length();
					res.add(s.substring(start, end));
					i = end + 1;
				} else if (s.charAt(i + 1) == '*') {
					start = i;
					int end = s.indexOf("*/", start) + 2;
					res.add(s.substring(start, end));
					i = end;
				}
			}
		}
		return res;
	}

	public ArrayList<String> getComments(Reader in) throws IOException {
		ArrayList<String> res = new ArrayList<String>();
		BufferedReader br = new BufferedReader(in);
		String line = null;
		int doublequote = 0;
		int singlequote = 0;
		boolean multilines = false;
		String comment = "";

		while ((line = br.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '\'')
					singlequote++;
				else if (line.charAt(i) == '"')
					doublequote++;
				else if (multilines == false && i + 1 < line.length()
						&& singlequote % 2 == 0 && singlequote % 2 == 0) {
					if (line.charAt(i) == '/') {
						if (line.charAt(i + 1) == '/') {
							res.add(line.substring(i));
							break;
						} else if (line.charAt(i + 1) == '*') {
							int end = line.indexOf("*/");
							if (end == -1) {
								multilines = true;
								comment = line.substring(i);
								break;
							} else {
								comment = line.substring(i, end + 2);
								res.add(comment);
								i = end + 1;
							}
						}
					}
				} else if (multilines) {
					int end = line.indexOf("*/");
					if (end == -1) {
						comment += "\n" + line;
						break;
					} else {
						multilines = false;
						comment += "\n" + line.substring(0, end + 2);
						res.add(comment);
						i = end + 1;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Comments q = new Comments();
		System.out
				.println(q
						.getComments(
								"This is code. // comment1 \n /* This is second comment // comment 2*/")
						.toString());
		System.out.println(q.getComments("").toString());
		System.out.println(q.getComments(" This is code. // comment1")
				.toString());
		System.out.println(q.getComments("//").toString());
		System.out
				.println(q
						.getComments(
								"This is code. // comment1 \n This is second comment // comment 2")
						.toString());

		System.out
				.println(q
						.getComments(
								"This is code. // comment1 \n /* This is second comment // comment 2*/ This is third comment // comment 2")
						.toString());
		System.out
				.println(q
						.getComments(
								"This is code. // comment1 \n This is second comment // comment 2 \n /* This is third comment // comment 2*/")
						.toString());
	}
}
