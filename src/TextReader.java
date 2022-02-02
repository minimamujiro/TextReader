import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class TextReader {
	private String path;

	private static Logger logger = Logger.getLogger(TextReader.class.getName());

	public enum Signal {
		START, END;
	}
	// private static final String START = "START";
	// private static final String END = "END";

	private TextReader(String path) { // TextReaderのコンストラクタ
		this.path = path; // args[0]内の参照アドレスをメンバ変数pathへ
	}

	private void execute() {
		List<Integer> valueList = new ObjectList<Integer>(); // Object型のlistの宣言
		// List valueList = new ArrayList();
		// FileReader fr = null; //frにnull代入
		// BufferedReader br = null; //brにnull代入
		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr);) {
			// メンバ変数pathのファイルを読み込む
			// ローカル変数frのテキストファイルを読み込む
			String line; // line変数を宣言
			while ((line = br.readLine()) != null) { // br変数から1行テキストを読み込んでローカル変数lineに代入、nullではないかを判定
				valueList.add(Integer.valueOf(line)); // nullでは無かったらvalueListに追加（末尾に追加）
				// valueList.add(new Integer(line));
			}
		} catch (IOException e) { // 入力時に例外が発生！！（）
			e.printStackTrace(); // スタックトレースを出力
		} // finally { //例外発生してもこれだけはやって〜
			// if (br != null) { //brがnullじゃ無かったら
			// try {
			// br.close(); //brファイルを閉じて！！
			// } catch (IOException e) {
			// }
			// }
			// if (fr != null) { //brがnullじゃ無かったら
			// try {
			// fr.close();
			// } catch (IOException e) {
			// }
			// }
			// }
		for (Integer value : valueList) {
			System.out.println(value);
		}
		// int size = valueList.size(); //リストはどれだけあるの？？
		// for (int i = 0; i < size; i++) { //リストの数だけ繰り返して！！
		// System.out.println(valueList.get(i)); //リストを出力して！！
	}

	public static void main(String... args) {
		logger.info(Signal.START.name()); // logger.info(START); //情報：STARTと表示する
		new TextReader(args[0]).execute(); // args[0]の中身をexecuteで実行する
		logger.info(Signal.END.name()); // logger.info(END); //情報：ENDと表示する
	}
}