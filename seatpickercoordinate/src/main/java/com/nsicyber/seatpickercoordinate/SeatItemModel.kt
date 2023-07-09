package com.nsicyber.seatpickercoordinate

import android.os.Parcel
import android.os.Parcelable

class SeatItemModel() : Parcelable {

    var ticketTypeName:String?=null
        get() = field
        set(value) {
            field = value
        }
    var seatIsLeft:Boolean?=false
        get() = field
        set(value) {
            field = value
        }

    var seatDesignId: Int = 0
        get() = field
        set(value) {
            field = value
        }
    var seatTypeId: Int? = null
        get() = field
        set(value) {
            field = value
        }


    var seatName: String? = null
        get() = field
        set(value) {
            field = value
        }


    var rowName: String? = null
        get() = field
        set(value) {
            field = value
        }

    var seatOrderNumber: Int? = null
        get() = field
        set(value) {
            field = value
        }


    var x:Int? = null
        get() {
            field?.let {
                return it
            } ?: run {
                if (seatIsLeft == false) {
                    return ((seatOrderNumber ?: 0) * 34) - 2
                }
                return (seatOrderNumber ?: 0) * 34;
            }
        }
        set(value) {
            field = value
        }


    var y: Int? = null
        get() = field
        set(value) {
            field = value
        }


    var width: Int = 30
        get() = field
        set(value) {
            field = value
        }


    var height: Int = 30
        get() = field
        set(value) {
            field = value
        }


    var alignment: Int? = 0
        get() = field
        set(value) {
            field = value
        }


    var entrance: String? = ""
        get() = field
        set(value) {
            field = value
        }


    var ticketTypeId: Int? = null
        get() = field
        set(value) {
            field = value
        }


    var seatAmount: Double? = null
        get() = field
        set(value) {
            field = value
        }


    var isClosed: Int? = null
        get() = field
        set(value) {
            field = value
        }


    var isProtocol: Int? = null
        get() = field
        set(value) {
            field = value
        }


    var kisitli: Int? = null
        get() = field
        set(value) {
            field = value
        }


    var loveSeatGroupId: String? = null
        get() = field
        set(value) {
            field = value
        }


    var seatStatus: Int? = null
        get() = field
        set(value) {
            field = value
        }


    constructor(parcel: Parcel) : this() {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SeatItemModel> {
        override fun createFromParcel(parcel: Parcel): SeatItemModel {
            return SeatItemModel(parcel)
        }

        override fun newArray(size: Int): Array<SeatItemModel?> {
            return arrayOfNulls(size)
        }
    }


}