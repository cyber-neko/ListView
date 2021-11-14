package com.androiddevs.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.androiddevs.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuList = mutableListOf("から揚げ定食", "ハンバーグ定食", "生姜焼き定食", "ステーキ定食",
            "野菜炒め定食", "とんかつ定食", "ミンチカツ定食", "チキンカツ定食", "コロッケ定食",
            "回鍋肉定食", "麻婆豆腐定食", "青椒肉絲定食", "焼き魚定食", "焼肉定食")
        //アダプタオブジェクト、第２引数では専用のレイアウト用のXMLファイルを作成しR値を指定する
        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1,
        menuList)
        binding.lvMenu.adapter = adapter

        binding.lvMenu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val item = parent!!.getItemAtPosition(position) as String
            val show = "あなたが選んだ定食: " + item
            Toast.makeText(this@MainActivity, show, Toast.LENGTH_SHORT).show()

            val dialogFragment = OrderConfirmDialogFragment()
            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")
        }
    }
}