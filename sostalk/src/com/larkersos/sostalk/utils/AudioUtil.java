package com.larkersos.sostalk.utils;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.larkersos.sostalk.R;

/**
 * �ֽں��������ݹ�����
 * @author lark
 *
 */
public class AudioUtil extends Util{
	
	/**
     * ��������
     * @param sound
     * @param loop
     */
    public static void playSound(Context contet) {
    	playSound(contet, R.raw.dingdong, 1);
    }
    public static void playSound(Context contet,int sound, int loop) {
    	// �ʺϲ���ʵʱ��ʵ��ͬʱ���Ŷ������������Ϸ��ը���ı�ը����С��Դ�ļ���������Ƶ�Ƚ��ʺϷŵ���Դ�ļ��� res/raw�ºͳ���һ����APK�ļ�
    	SoundPool soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);

    	// ��Ƶ�Ƚ��ʺϷŵ���Դ�ļ��� res/raw��
        HashMap<Integer, Integer> soundPoolMap = new HashMap<Integer, Integer>(); 
        soundPoolMap.put(R.raw.system, soundPool.load(contet, R.raw.system, 1));  
        soundPoolMap.put(R.raw.logon, soundPool.load(contet, R.raw.logon, 1));  
        soundPoolMap.put(R.raw.msg123, soundPool.load(contet, R.raw.msg123, 1));  
        soundPoolMap.put(R.raw.dingdong, soundPool.load(contet, R.raw.dingdong, 1));  
        soundPoolMap.put(R.raw.calling, soundPool.load(contet, R.raw.calling, 1));

        // ִ�в���
        AudioManager mgr = (AudioManager)contet.getSystemService(Context.AUDIO_SERVICE);   
        float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);   
        float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);       
        float volume = streamVolumeCurrent/streamVolumeMax;   

        //������1��Map��ȡֵ   2����ǰ����     3���������  4�����ȼ�   5���ز�����   6�������ٶ�
        soundPool.play(soundPoolMap.get(sound), volume, volume, 1, loop, 1f);
}}
