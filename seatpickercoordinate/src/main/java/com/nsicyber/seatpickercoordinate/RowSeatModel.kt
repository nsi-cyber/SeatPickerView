package com.nsicyber.seatpickercoordinate

data class RowSeatModel(
    val rowId: Int,
    val rowName: String,
    val rowOrderNumber: Int,
    var seatList: List<SeatItemModel>
)  {
    @JvmName("getSeatList1")
    fun getSeatList() : List<SeatItemModel> {
        var tempDoubleSeatCount = 0;
        seatList.forEach { seat ->
            seat.y = rowOrderNumber * 34;
            seat.rowName = rowName
            if (seat.seatTypeId == 2) {
                seat.seatIsLeft = tempDoubleSeatCount % 2 == 0
                tempDoubleSeatCount++
                seat.width = 32
            }
        }
        return  seatList;
    }
}

