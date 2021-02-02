package jp.co.bhopari.timetransform;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import jp.co.bhopari.timetransform.services.impl.TimeTransformServiceImpl;



public class TimeTransformServiceTest {

	//サービスクラスのインスタンスを生成
	TimeTransformServiceImpl hourTestInstance = new TimeTransformServiceImpl();


	//テストケース①～④は例外の発生が正しく行われているかのテスト
	//⑤～⑧は時間表記変換結果が想定していた通りかを確認するテスト

	//テストケース①
	//入力値hourが0未満の時、IllegalArgumentExceptionが発生すれば成功
	//入力値hourが0未満の境界値のテスト
	@Test
	public void 入力値hourが0未満境界値テスト() {

		//入力値hourを-1にして時間表記変換メソッドを呼び出し、IllegalArgumentExceptionが発生することを確認
		assertThrows(IllegalArgumentException.class, () -> hourTestInstance.transformTime(-1, 0));

	}

	//テストケース②
	//入力値hourが0以上99未満の時、IllegalArgumentExceptionが発生しなければ成功
	//入力値hourが0以上の境界値のテスト
	@Test
	public void 入力値hourが0以上99以下_0前後境界値テスト() {

		//入力値hourを0にして時間表記変換メソッドを呼び出し、IllegalArgumentExceptionが発生しないことを確認
		assertDoesNotThrow(() -> hourTestInstance.transformTime(0, 0));

	}

	//テストケース③
	//入力値hourが0以上99未満の時、IllegalArgumentExceptionが発生しなければ成功
	//入力値hourが99以下の境界値のテスト
	@Test
	public void 入力値hourが0以上99以下_99前後境界値テスト() {

		//入力値hourを99にして時間表記変換メソッドを呼び出し、IllegalArgumentExceptionが発生しないことを確認
		assertDoesNotThrow(() -> hourTestInstance.transformTime(99, 0));

	}

	//テストケース④
	//入力値hourが100以上の時、IllegalArgumentExceptionが発生すれば成功
	//入力値hourが100以上の境界値のテスト
	@Test
	public void 入力値hourが100以上境界値テスト() {

		//入力値hourを100にして時間表記変換メソッドを呼び出し、IllegalArgumentExceptionが発生することを確認
		assertThrows(IllegalArgumentException.class, () -> hourTestInstance.transformTime(100, 0));

	}

	//テストケース⑤
	//時間表記変換結果が想定値通りであれば成功
	//入力値hourが0, 入力値minuteが0の場合
	@Test
	public void 入力値hourが0_入力値minuteが0テスト() {

		//想定値を変数に格納
		int expected = 0;
		//時間表記変換メソッドの結果を変数に格納
		int actual = hourTestInstance.transformTime(0, 0);

		//想定値と実際の値を比較
		assertThat(expected, is(actual));
	}

	//テストケース⑥
	//時間表記変換結果が想定値通りであれば成功
	//入力値hourが50, 入力値minuteが0の場合
	@Test
	public void 入力値hourが50_入力値minuteが0テスト() {

		//想定値を変数に格納
		int expected = 3000;
		//時間表記変換メソッドの結果を変数に格納
		int actual = hourTestInstance.transformTime(50, 0);

		//想定値と実際の値を比較
		assertThat(expected, is(actual));
	}

	//テストケース⑦
	//時間表記変換結果が想定値通りであれば成功
	//入力値hourが99, 入力値minuteが0の場合
	@Test
	public void 入力値hourが99_入力値minuteが0テスト() {

		//想定値を変数に格納
		int expected = 5940;
		//時間表記変換メソッドの結果を変数に格納
		int actual = hourTestInstance.transformTime(99, 0);

		//想定値と実際の値を比較
		assertThat(expected, is(actual));
	}

	//テストケース⑧
	//時間表記変換結果が想定値通りであれば成功
	//入力値hourが0, 入力値minuteが30の場合
	@Test
	public void 入力値hourが0_入力値minuteが30テスト() {

		//想定値を変数に格納
		int expected = 30;
		//時間表記変換メソッドの結果を変数に格納
		int actual = hourTestInstance.transformTime(0, 30);

		//想定値と実際の値を比較
		assertThat(expected, is(actual));
	}

	//テストケース⑨
	//時間表記変換結果が想定値通りであれば成功
	//入力値hourが50, 入力値minuteが30の場合
	@Test
	public void 入力値hourが50_入力値minuteが30テスト() {

		//想定値を変数に格納
		int expected = 3030;
		//時間表記変換メソッドの結果を変数に格納
		int actual = hourTestInstance.transformTime(50, 30);

		//想定値と実際の値を比較
		assertThat(expected, is(actual));
	}

	//テストケース⑩
	//時間表記変換結果が想定値通りであれば成功
	//入力値hourが99, 入力値minuteが30の場合
	@Test
	public void 入力値hourが99_入力値minuteが30テスト() {

		//想定値を変数に格納
		int expected = 5970;
		//時間表記変換メソッドの結果を変数に格納
		int actual = hourTestInstance.transformTime(99, 30);

		//想定値と実際の値を比較
		assertThat(expected, is(actual));
	}

	//テストケース⑪
	//時間表記変換結果が想定値通りであれば成功
	//入力値hourが0, 入力値minuteが59の場合
	@Test
	public void 入力値hourが0_入力値minuteが59テスト() {

		//想定値を変数に格納
		int expected = 59;
		//時間表記変換メソッドの結果を変数に格納
		int actual = hourTestInstance.transformTime(0, 59);

		//想定値と実際の値を比較
		assertThat(expected, is(actual));
	}

	//テストケース⑫
	//時間表記変換結果が想定値通りであれば成功
	//入力値hourが50, 入力値minuteが59の場合
	@Test
	public void 入力値hourが50_入力値minuteが59テスト() {

		//想定値を変数に格納
		int expected = 3059;
		//時間表記変換メソッドの結果を変数に格納
		int actual = hourTestInstance.transformTime(50, 59);

		//想定値と実際の値を比較
		assertThat(expected, is(actual));
	}

	//テストケース⑬
	//時間表記変換結果が想定値通りであれば成功
	//入力値hourが99, 入力値minuteが59の場合
	@Test
	public void 入力値hourが99_入力値minuteが59テスト() {

		//想定値を変数に格納
		int expected = 5999;
		//時間表記変換メソッドの結果を変数に格納
		int actual = hourTestInstance.transformTime(99, 59);

		//想定値と実際の値を比較
		assertThat(expected, is(actual));
	}
}
