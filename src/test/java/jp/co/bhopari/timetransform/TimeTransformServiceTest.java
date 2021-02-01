package jp.co.bhopari.timetransform;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import jp.co.bhopari.timetransform.services.impl.TimeTransformServiceImpl;



public class TimeTransformServiceTest {

	//サービスクラスのインスタンスを生成
	TimeTransformServiceImpl hourTestInstance = new TimeTransformServiceImpl();

	//入力値minuteを定数化
	private static final int ZERO_MINUTE = 0;

	//入力値hourが0未満の時、IllegalArgumentExceptionが発生すれば成功
	//入力値hourが0未満の境界値のテスト
	@Test
	public void 入力値hourが0未満境界値Test() {

		//入力値hourを-1にして時間表記変換メソッドを呼び出し、IllegalArgumentExceptionが発生することを確認
		assertThrows(IllegalArgumentException.class, () -> hourTestInstance.transformTime(-1, ZERO_MINUTE));

	}

	//入力値hourが0以上99未満の時、IllegalArgumentExceptionが発生しなければ成功
	//入力値hourが0以上の境界値のテスト
	@Test
	public void 入力値hourが0以上99以下_0前後境界値Test() {

		//入力値hourを0にして時間表記変換メソッドを呼び出し、IllegalArgumentExceptionが発生しないことを確認
		assertDoesNotThrow(() -> hourTestInstance.transformTime(0, ZERO_MINUTE));

	}

	//入力値hourが0以上99未満の時、IllegalArgumentExceptionが発生しなければ成功
	//入力値hourが99以下の境界値のテスト
	@Test
	public void 入力値hourが0以上99以下_99前後境界値Test() {

		//入力値hourを99にして時間表記変換メソッドを呼び出し、IllegalArgumentExceptionが発生しないことを確認
		assertDoesNotThrow(() -> hourTestInstance.transformTime(99, ZERO_MINUTE));

	}

	//入力値hourが100以上の時、IllegalArgumentExceptionが発生すれば成功
	//入力値hourが100以上の境界値のテスト
	@Test
	public void 入力値hourが100以上境界値Test() {

		//入力値hourを100にして時間表記変換メソッドを呼び出し、IllegalArgumentExceptionが発生することを確認
		assertThrows(IllegalArgumentException.class, () -> hourTestInstance.transformTime(100, ZERO_MINUTE));

	}
}
