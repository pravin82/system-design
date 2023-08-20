class Floor(val floorNo:Int,val noOfSlots:Int) {
    val slots =(1..noOfSlots).map{
        val vehicle = when(it){
            1 -> VehicleType.TRUCK
            2,3->VehicleType.BIKE
            else -> VehicleType.CAR
        }
       Slot(it, vehicle)
    }.toMutableList()

    fun getFreeSlots(vehicleType: VehicleType):List<Slot>{
       return slots.filter{it.isAvailable}.filter{it.vehicleType == vehicleType}
    }

    fun getOccupiedSlots(vehicleType: VehicleType):List<Slot>{
        return slots.filterNot{it.isAvailable}.filter{it.vehicleType == vehicleType}
    }




}