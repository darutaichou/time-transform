package jp.co.bhopari.timetransform.services;

/**
 *
 * @author adgjm
 * 何時間何分を何分に変換する機能を提供するサービス
 */


public interface TimeTransformService {

	// 変換

	/**
	 *
	 * @param hour 数値入力ボックスhourに入力された値
	 * @param minute 数値入力ボックスminuteに入力された値
	 * @return 変換結果
	 * @throws IllegalArgumentException
	 */

	int transformTime(int hour, int minute) throws IllegalArgumentException;
}
