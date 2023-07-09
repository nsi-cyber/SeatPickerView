package com.nsicyber.seatpickercoordinate

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * TODO: document your custom view class.
 */
class SeatButton : FrameLayout {

var seatData:SeatItemModel?=null
    var selectedSeatDrawableColor: Int = Color.parseColor("#04B779")
    var takenSeatDrawableColor: Int = Color.parseColor("#B4B5B9")
    var emptySeatDrawableColor: Int = Color.parseColor("#E6EAEA")
    lateinit var linearLayout: LinearLayout
    lateinit var frameLayout: FrameLayout
    lateinit var imageView:ImageView
    lateinit var textView:TextView
    var isButtonSelected = false



    fun updateSeat() {

        if (isButtonSelected) {
            imageView.setColorFilter(emptySeatDrawableColor)
            isButtonSelected = false
        } else {
            imageView.setColorFilter(selectedSeatDrawableColor)
            isButtonSelected = true

        }
    }

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }


    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        LayoutInflater.from(context)
            .inflate(R.layout.sample_seat_button, this, true)
        frameLayout=findViewById(R.id.frameLay)
        imageView=findViewById(R.id.imageView)
        textView=findViewById(R.id.textView)

    }

    fun initView(seatData: SeatItemModel){
        this.seatData=seatData


        isClickable = true
        // FrameLayout oluşturun ve boyutlarını API'den gelen verilere göre ayarlayın
        val layoutParams = FrameLayout.LayoutParams(
            seatData.width,
            seatData.height
        )
        layoutParams.gravity = Gravity.CENTER
        frameLayout.layoutParams = layoutParams



        var imageResource = R.drawable.seat_normal
        if (seatData.seatTypeId == 2) {
            if (seatData.seatIsLeft == true)
                imageResource = R.drawable.seat_double_left
            else imageResource = R.drawable.seat_double_right
        }


        imageView.setImageResource(imageResource)
        // Placeholder image ekleyin



//        textView.textSize = 5f

        textView.text =
            seatData.seatName.toString() // API'den gelen seatName'i ayarlayın




        when (seatData.seatStatus) {
            0 -> {
                frameLayout.isClickable = true
                imageView.setColorFilter(emptySeatDrawableColor)
            }
            else -> {
                frameLayout.isClickable = false
                imageView.setColorFilter(takenSeatDrawableColor)

            }

        }

    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
        val paddingLeft = paddingLeft
        val paddingTop = paddingTop
        val paddingRight = paddingRight
        val paddingBottom = paddingBottom

        val contentWidth = width - paddingLeft - paddingRight
        val contentHeight = height - paddingTop - paddingBottom


    }
}