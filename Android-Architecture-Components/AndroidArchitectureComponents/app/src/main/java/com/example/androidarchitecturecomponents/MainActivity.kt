package com.example.androidarchitecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.androidarchitecturecomponents.databinding.ActivityMainBinding

/**
 * DataBinding 사용
 * -> viewBinding 삭제
 *
 * lifecycle 관찰을 위해 lifecycleOwner를 만들고 xml view와 연동할 데이터를 가지고 있는 viewModel 지정
 * liveData를 observing 하지 않아도 DataBinding을 통해 화면에서 카운터를 보여줄 수 있다.
 * */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(binding.root)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        /**
         * Activity는 counter를 읽어 오고 저장할 때 viewModel을 사용
         * ViewModelProvider()을 사용해 인스턴스를 싱글톤으로 생성
         * ViewModelProvider() 사용 시 초기값 전달이 금지되어 있어 Factory pattern 사용
         * */
//        val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
//        myViewModel.counter = 100
//        binding.textView.text = myViewModel.counter.toString()
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//        }

        /**
         * Factory 사용
         * 전달하고자 하는 초기 값을 factory에 전달해줌
         * ViewModelProvider()는 factory를 함께 받아 factory를 통해 MyViewModel을 생성하도록 함
         * */
//        val factory = MyViewModelFactory(100)
//        val myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
//        binding.textView.text = myViewModel.counter.toString()
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//        }

        /**
         * ViewModelProvider() 사용하지 않고 초기화
         * */
//        val factory = MyViewModelFactory(100)
//        val myViewModel by viewModels<MyViewModel>()
//        binding.textView.text = myViewModel.counter.toString()
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//        }

        /**
         * saveState 사용
         * counter 값 증가할 때 마다 saveState()에 값 저장
         * */
//        val factory = MyViewModelFactory(100, this)
//        val myViewModel by viewModels<MyViewModel>() { factory }
//        binding.textView.text = myViewModel.counter.toString()
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//            myViewModel.saveState()
//        }

        /**
         * LiveData 사용
         * liveCounter를 observing하여 UI표시 로직을 더이상 버튼 클릭리스너 안에 둘 필요가 없다.
         * */
        val factory = MyViewModelFactory(10, this)
        val myViewModel by viewModels<MyViewModel>() { factory }

        binding.lifecycleOwner = this
        binding.viewmodel = myViewModel

        binding.button.setOnClickListener {
            myViewModel.liveCounter.value = myViewModel.liveCounter.value?.plus(1)
        }
//        myViewModel.liveCounter.observe(this) { counter ->
//            binding.textView.text = counter.toString()
//        }
        myViewModel.modifiedCounter.observe(this) { counter ->
            binding.textView.text = counter.toString()
        }
    }
}