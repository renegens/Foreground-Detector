package com.renegens.forgrounddetector.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.renegens.forgrounddetector.R
import com.renegens.forgrounddetector.injection.getDagger
import com.renegens.forgrounddetector.service.ForegroundDetector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var foregroundDetector: ForegroundDetector

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        getDagger().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disposable = foregroundDetector
                .foregroundObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Toast.makeText(this, "$it", Toast.LENGTH_LONG).show()
                }, {})

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
