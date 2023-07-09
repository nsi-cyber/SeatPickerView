package com.nsicyber.seatpickercoordinate

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout

/**
 * TODO: document your custom view class.
 */
class SeatPickerCoordinateView : LinearLayout {

    var seatItemClickListener: SeatItemClickListener? = null


    var selectedSeatDrawableColor: Int = Color.parseColor("#04B779")
    var takenSeatDrawableColor: Int = Color.parseColor("#B4B5B9")
    var emptySeatDrawableColor: Int = Color.parseColor("#E6EAEA")


    lateinit var relativeLay: RelativeLayout

    fun reverseLayout(list: List<SeatItemModel>?): List<SeatItemModel> {

        list?.let {
            var tempList = list
            var maximumY = 0
            for (seatData in list) {
                if (seatData.y!! > maximumY)
                    maximumY = seatData.y!!
            }

            for (seatData in tempList) {
                seatData.y = Math.abs(seatData.y!! - maximumY)
            }
            return tempList

        }

        return emptyList()


    }


    fun setSeatsToLayout(list: List<SeatItemModel>?) {
        relativeLay.removeAllViews()
        list?.let {
            for (seatData in list) {

                if (seatData.seatTypeId!! != 3) {
                    var seatButton = SeatButton(context)

                    val params = RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                    )
                    params.leftMargin = seatData.x!!
                    params.topMargin = seatData.y!!
                    //params.bottomMargin = seatData.y!!

                    seatButton.initView(seatData)
                    relativeLay.addView(seatButton, params)
//balkonların tıklanmasını engelle
                    if (seatData.seatTypeId != 5
                    ) {
                        seatButton.frameLayout.setOnClickListener {
                            seatItemClickListener!!.onSeatItemClick(seatButton)
                        }
                    }


                }


            }
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


    fun startView(startData: List<SeatItemModel>?, isReverse: Boolean) {
        if (isReverse)
            setSeatsToLayout(reverseLayout(startData))
        else
            setSeatsToLayout(startData)


    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        LayoutInflater.from(context)
            .inflate(R.layout.sample_seat_picker_coordinate_view, this, true)
        relativeLay = findViewById(R.id.relativeLay)
    }


}


