package jp.co.bhopari.timetransform.services.impl;

import org.springframework.stereotype.Service;

import jp.co.bhopari.timetransform.services.TimeTransformService;

/**
*
* @author adgjm
* 何時間何分を何分に変換する機能を提供するサービス
*/

//実装したクラス
@Service
public class TimeTrasformServiceimpl implements TimeTransformService {

	//数値入力値ボックスhourにそれぞれ入力できる範囲の最大値と最小値
	private static final int HOUR_MAX = 99;
	private static final int HOUR_MIN = 0;

	@Override
	public int transformTime(int hour, int minute) throws IllegalArgumentException {

		//入力値hour入力チェック
		if (hour < HOUR_MIN || hour > HOUR_MAX) {
			throw new IllegalArgumentException();
		}

		//入力値hourを分表記に変換
		int transformedHour = hour*60;

		//加算
		int result = transformedHour + minute;
		return result;

	}

}
