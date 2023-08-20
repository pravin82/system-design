import java.util.*

enum class Command(val commandName:String){
   CREATE_PARKING_LOT("create_parking_lot"),
    DISPLAY("display"),
    EXIT("exit");
    companion object {
        fun getCommand(name:String):Command{
         return  when(name){
               CREATE_PARKING_LOT.commandName -> CREATE_PARKING_LOT
               DISPLAY.commandName -> DISPLAY
               EXIT.commandName -> EXIT
               else -> EXIT

           }
        }
    }

}

enum class VehicleType(val type:String){
    TRUCK("TRUCK"),
    CAR("CAR"),
    BIKE("BIKE");
    companion object {
        fun getVehicle(name: String):VehicleType{
            return when(name){
                TRUCK.type -> TRUCK
                CAR.type -> CAR
                BIKE.type -> BIKE
                else -> BIKE
            }
        }
    }
}

enum class DisplayType(val type:String){
    FREE_COUNT("free_count"),
    FREE_SLOT("free_slots"),
    OCCUPIED_SLOT("occupied_slots");
    companion object {
        fun getDisplayType(type:String):DisplayType{
            return when(type){
               FREE_COUNT.type -> FREE_COUNT
                FREE_SLOT.type -> FREE_SLOT
                OCCUPIED_SLOT.type -> OCCUPIED_SLOT
                else -> FREE_SLOT
            }
        }
    }
}