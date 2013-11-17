package com.larkersos.sostalk.utils;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.larkersos.sostalk.R;

/**
 * 字节和整数数据工具类
 * @author lark
 *
 */
public class AudioUtil extends Util{
	
	/**
     * 播放声音
     * @param sound
     * @param loop
     */
    public static void playSound(Context contet) {
    	playSound(contet, R.raw.dingdong, 1);
    }
    public static void playSound(Context contet,int sound, int loop) {
    	// 适合播放实时音实现同时播放多个声音，如游戏中炸弹的爆炸音等小资源文件，此类音频比较适合放到资源文件夹 res/raw下和程序一起打成APK文件
    	SoundPool soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);

    	// 音频比较适合放到资源文件夹 res/raw下
        HashMap<Integer, Integer> soundPoolMap = new HashMap<Integer, Integer>(); 
        soundPoolMap.put(R.raw.system, soundPool.load(contet, R.raw.system, 1));  
        soundPoolMap.put(R.raw.logon, soundPool.load(contet, R.raw.logon, 1));  
        soundPoolMap.put(R.raw.msg123, soundPool.load(contet, R.raw.msg123, 1));  
        soundPoolMap.put(R.raw.dingdong, soundPool.load(contet, R.raw.dingdong, 1));  
        soundPoolMap.put(R.raw.calling, soundPool.load(contet, R.raw.calling, 1));

        // 执行播放
        AudioManager mgr = (AudioManager)contet.getSystemService(Context.AUDIO_SERVICE);   
        float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);   
        float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);       
        float volume = streamVolumeCurrent/streamVolumeMax;   

        //参数：1、Map中取值   2、当前音量     3、最大音量  4、优先级   5、重播次数   6、播放速度
        soundPool.play(soundPoolMap.get(sound), volume, volume, 1, loop, 1f);
}}
