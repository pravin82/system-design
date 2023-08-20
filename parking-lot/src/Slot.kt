 class Slot(val slotNo:Int, val vehicleType:VehicleType) {
    var isAvailable = true
    val vehicleId:String = ""


    fun parkVehicle(vehicle: VehicleType){
        isAvailable = false

    }
}