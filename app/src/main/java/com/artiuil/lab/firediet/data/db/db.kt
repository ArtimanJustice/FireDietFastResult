package com.artiuil.lab.firediet.data.db

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("calorie_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_BASE_GOAL = "base_goal"
        private const val KEY_FOOD_CONSUMED = "food_consumed"
    }

    fun saveBaseGoal(baseGoal: Int) {
        prefs.edit().putInt(KEY_BASE_GOAL, baseGoal).apply()
    }

    fun getBaseGoal(): Int {
        return prefs.getInt(KEY_BASE_GOAL, 2140)
    }

    fun saveFoodConsumed(foodConsumed: Int) {
        prefs.edit().putInt(KEY_FOOD_CONSUMED, foodConsumed).apply()
    }

    fun getFoodConsumed(): Int {
        return prefs.getInt(KEY_FOOD_CONSUMED, 0)
    }
}