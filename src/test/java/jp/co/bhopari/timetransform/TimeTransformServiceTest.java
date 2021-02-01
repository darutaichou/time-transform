package jp.co.bhopari.timetransform;

import org.junit.jupiter.api.Test;

import jp.co.bhopari.timetransform.services.impl.TimeTransformServiceImpl;


public class TimeTransformServiceTest {

	//サービスクラスのインスタンスを生成
	TimeTransformServiceImpl hourTestInstance = new TimeTransformServiceImpl();

	//入力値minuteを定数化
	private static final int ZERO_MINUTE = 0;

	// 入力値hourが0未満の場合の境界値テスト
	@Test(expected = IllegalArgumentException.class)
	public void hourCheckTest() {

		//入力値hourを-1にして時間表記変換メソッドを呼び出す
		hourTestInstance.transformTime(-1, ZERO_MINUTE);

	}
}
