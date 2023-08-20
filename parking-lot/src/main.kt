
fun main(args:Array<String>){
   var takeInput = true
   println("Enter the command")
   var parkingLot =  ParkingLot("", emptyList() )
   while(takeInput){
      val commandWithArgs = readLine()
      val commandArr = commandWithArgs?.split(" ")?: emptyList()
      val command = commandArr.firstOrNull()?:"exit"
      val commandArgs = when(commandArr.size > 1){
        true -> commandArr.subList(1,commandArr.size)
         else -> emptyList()
      }
      println("command:${command}")
      when(Command.getCommand(command)){
         Command.DISPLAY -> handleDisplay(commandArgs, parkingLot)
         Command.CREATE_PARKING_LOT -> {parkingLot = createParkingLot(commandArgs)}
         Command.EXIT -> {takeInput = false}
      }
   }

}

fun handleDisplay(args:List<String>, parkingLot: ParkingLot){
   val displayType = DisplayType.getDisplayType(args.first())
   val vehicle = VehicleType.getVehicle(args.get(1))
    when(displayType){
      DisplayType.FREE_COUNT -> {displayFreeCount(parkingLot,vehicle)}
       DisplayType.FREE_SLOT -> {displayFreeSlots(parkingLot,vehicle)}
       DisplayType.OCCUPIED_SLOT -> {displayOccupiedSlot(parkingLot, vehicle)}
   }

}

fun createParkingLot(args:List<String>):ParkingLot{
   println("create parking lot called with args:${args}")
   val parkingLotId = args.first()
   val noOfFloors = args.get(1).toInt()
   val noOfSlots = args.get(2).toInt()
   val floors = (1..noOfFloors).map{
      Floor(it,noOfSlots)
   }
   val parkingLot = ParkingLot("abs", floors)

   println("Created parking lot with ${noOfFloors} floors and ${noOfSlots} slots per floor")
   return parkingLot

}

fun displayFreeCount(parkingLot: ParkingLot,vehicleType: VehicleType){
   parkingLot.floors.map{
    val freeSlot =  it.getFreeSlots(vehicleType)
      println("No of free slots for ${vehicleType.type} on Floor ${it.floorNo}: ${freeSlot.size} ")
   }

}

fun displayFreeSlots(parkingLot: ParkingLot,vehicleType: VehicleType){
   parkingLot.floors.map{
      val freeSlot =  it.getFreeSlots(vehicleType)
      println("Free slots for ${vehicleType.type} on Floor ${it.floorNo}: ${freeSlot.map{it.slotNo}.joinToString()}")
   }

}

fun displayOccupiedSlot(parkingLot: ParkingLot, vehicleType: VehicleType){
   parkingLot.floors.map{
      val freeSlot =  it.getOccupiedSlots(vehicleType)
      println("Occupied slots for ${vehicleType.type} on Floor ${it.floorNo}: ${freeSlot.map{it.slotNo}.joinToString()}")
   }

}




