package converter
import java.util.Scanner

enum class Converter(val title:String, val coef:Double, val type:String){
    METER("meter", 1.0, "length"),
    KILOMETER("kilometer",1000.0, "length"),
    CENTIMETER("centimeter",0.01, "length"),
    MILLIMETER("millimeter", 0.001, "length"),
    MILE("mile",1609.35, "length"),
    YARD("yard",0.9144, "length"),
    FOOT("foot",0.3048, "length"),
    INCH("inch",0.0254, "length"),
    GRAM("gram", 1.0, "weight"),
    KILOGRAM("kilogram",1000.0, "weight"),
    MILLIGRAM("milligram",0.001, "weight"),
    POUND("pound",453.592, "weight"),
    OUNCE("ounce",28.3495, "weight"),
    C("celsius", 1.0, "temperature"),
    F("fahrenheit", 1.0, "temperature"),
    K("kelvin", 1.0, "temperature");
    companion object{
        fun getCoefficient(measure:String):Double{
            for(enum in Converter.values()){
                if(measure.toLowerCase() == enum.title)
                    return enum.coef
            }
            return 0.0
        }
        fun getTitle(measure:String):String{
            for(enum in Converter.values()){
                if(measure.toLowerCase() == enum.title)
                    return enum.title
            }
            return "???"
        }
        fun getType(measure:String):String{
            for(enum in Converter.values()){
                if(measure.toLowerCase() == enum.title)
                    return enum.type
            }
            return "???"
        }
        fun check(from:String,to:String):Boolean{
            if(getType(from) == getType(to))
                return true
            else
                return false
        }
    }

}

fun toMeterOrGram(number:Double, meas:String):Double{
    when(meas){
        in listOf("m", "meter", "meters") -> {
            val res = Converter.getCoefficient("meter")
            return number*res
        }
        in listOf("km", "kilometer", "kilometers") -> {
            val res = Converter.getCoefficient("kilometer")
            return number*res
        }
        in listOf("cm", "centimeter", "centimeters") -> {
            val res = Converter.getCoefficient("centimeter")
            return number*res
        }
        in listOf("mm", "millimeter", "millimeters") -> {
            val res = Converter.getCoefficient("millimeter")
            return number*res
        }
        in listOf("mi", "mile", "miles") -> {
            val res = Converter.getCoefficient("mile")
            return number*res
        }
        in listOf("yd", "yard", "yards") -> {
            val res = Converter.getCoefficient("yard")
            return number*res
        }
        in listOf("ft", "foot", "feet") -> {
            val res = Converter.getCoefficient("foot")
            return number*res
        }
        in listOf("in", "inch", "inches") -> {
            val res = Converter.getCoefficient("inch")
            return number*res
        }
        in listOf("g", "gram", "grams") -> {
            val res = Converter.getCoefficient("gram")
            return number*res
        }
        in listOf("kg", "kilogram", "kilograms") -> {
            val res = Converter.getCoefficient("kilogram")
            return number*res
        }
        in listOf("mg", "milligram", "milligrams") -> {
            val res = Converter.getCoefficient("milligram")
            return number*res
        }
        in listOf("lb", "pound", "pounds") -> {
            val res = Converter.getCoefficient("pound")
            return number*res
        }
        in listOf("oz", "ounce", "ounces") -> {
            val res = Converter.getCoefficient("ounce")
            return number*res
        }
    }
    return 0.0
}

fun getName(meas:String, sp:Boolean):String {
    when (meas) {
        in listOf("m", "meter", "meters") -> {
            if(sp)
                return Converter.getTitle("meter")
            else
                return Converter.getTitle("meter")+"s"
        }
        in listOf("km", "kilometer", "kilometers") -> {
            if(sp)
                return Converter.getTitle("kilometer")
            else
                return Converter.getTitle("kilometer")+"s"
        }
        in listOf("cm", "centimeter", "centimeters") -> {
            if(sp)
                return Converter.getTitle("centimeter")
            else
                return Converter.getTitle("centimeter")+"s"
        }
        in listOf("mm", "millimeter", "millimeters") -> {
            if(sp)
                return Converter.getTitle("millimeter")
            else
                return Converter.getTitle("millimeter")+"s"
        }
        in listOf("mi", "mile", "miles") -> {
            if(sp)
                return Converter.getTitle("mile")
            else
                return Converter.getTitle("mile")+"s"
        }
        in listOf("yd", "yard", "yards") -> {
            if(sp)
                return Converter.getTitle("yard")
            else
                return Converter.getTitle("yard")+"s"
        }
        in listOf("ft", "foot", "feet") -> {
            if(sp)
                return Converter.getTitle("foot")
            else
                return "feet"
        }
        in listOf("in", "inch", "inches") -> {
            if(sp)
                return Converter.getTitle("inch")
            else
                return Converter.getTitle("inch")+"es"
        }
        in listOf("g", "gram", "grams") -> {
            if(sp)
                return Converter.getTitle("gram")
            else
                return Converter.getTitle("gram")+"s"
        }
        in listOf("kg", "kilogram", "kilograms") -> {
            if(sp)
                return Converter.getTitle("kilogram")
            else
                return Converter.getTitle("kilogram")+"s"
        }
        in listOf("mg", "milligram", "milligrams") -> {
            if(sp)
                return Converter.getTitle("milligram")
            else
                return Converter.getTitle("milligram")+"s"
        }
        in listOf("lb", "pound", "pounds") -> {
            if(sp)
                return Converter.getTitle("pound")
            else
                return Converter.getTitle("pound")+"s"
        }
        in listOf("oz", "ounce", "ounces") -> {
            if(sp)
                return Converter.getTitle("ounce")
            else
                return Converter.getTitle("ounce")+"s"
        }
        in listOf("k", "kelvin", "kelvins") -> {
            if(sp)
                return "Kelvin" //Converter.getTitle("kelvin")
            else
                return "Kelvins" //Converter.getTitle("kelvin")+"s"
        }
        in listOf("c","dc","celsius") -> {
            return "Celsius" //Converter.getTitle("celsius")
        }
        in listOf("f","df","fahrenheit") -> {
            return "Fahrenheit" //Converter.getTitle("fahrenheit")
        }
    }
    return "???"
}

fun main() {
    val s = Scanner(System.`in`)
    loop@ while(true){
        print("Enter what you want to convert (or exit): ")
        val inputData = s.nextLine()
        val inputParts = inputData.split(" ")
        if(inputParts[0] == "exit")
            break
        val number = inputParts[0]
        val fromMeas:String
        val toMeas:String
        if(inputParts[1].toLowerCase() in listOf("degree","degrees")) {
            fromMeas = inputParts[2]
            if (inputParts[4].toLowerCase() in listOf("degree","degrees")) {
                toMeas = inputParts[5]
            } else {
                toMeas = inputParts[4]
            }
        }
        else {
            fromMeas = inputParts[1]
            if (inputParts[3].toLowerCase() in listOf("degree","degrees")) {
                toMeas = inputParts[4]
            } else {
                toMeas = inputParts[3]
            }
        }
        if(Converter.getTitle(getName(fromMeas.toLowerCase(),true).toLowerCase()) == "???") {
            println("Conversion from ??? to ${if (getName(toMeas.toLowerCase(),false) in listOf("Celsius", "Fahrenheit")) "degrees "+getName(toMeas.toLowerCase(),false) else getName(toMeas.toLowerCase(),false)} is impossible")
            continue@loop
        }
        var result:Double = 0.0
        if (Converter.check(getName(fromMeas.toLowerCase(),true).toLowerCase(),getName(toMeas.toLowerCase(),true).toLowerCase())){
            when(Converter.getType(getName(fromMeas.toLowerCase(),true).toLowerCase())){
                "length" -> {
                    if (number.toDouble() < 0.0){
                        println("Length shouldn't be negative")
                        continue@loop
                    } else{
                        var rs = toMeterOrGram(number.toDouble(),fromMeas.toLowerCase())
                        val res = Converter.getCoefficient(getName(toMeas.toLowerCase(),true))
                        result = rs/res
                        println("${number.toDouble()} ${if(1.0 != number.toDouble()) getName(fromMeas.toLowerCase(),false) else getName(fromMeas.toLowerCase(), true)} is ${result} ${if(1.0 != result) getName(toMeas.toLowerCase(),false) else getName(toMeas.toLowerCase(), true)}")
                    }
                }
                "weight" -> {
                    if (number.toDouble() < 0.0){
                        println("Weight shouldn't be negative")
                        continue@loop
                    } else{
                        var rs = toMeterOrGram(number.toDouble(),fromMeas.toLowerCase())
                        val res = Converter.getCoefficient(getName(toMeas.toLowerCase(),true))
                        result = rs/res
                        println("${number.toDouble()} ${if(1.0 != number.toDouble()) getName(fromMeas.toLowerCase(),false) else getName(fromMeas.toLowerCase(), true)} is ${result} ${if(1.0 != result) getName(toMeas.toLowerCase(),false) else getName(toMeas.toLowerCase(), true)}")
                    }
                }
                "temperature" -> {
                    when(getName(fromMeas.toLowerCase(),true).toLowerCase()){
                        "celsius" -> {
                            when(getName(toMeas.toLowerCase(),true).toLowerCase()){
                                "celsius" -> {
                                    result = number.toDouble()*1.0
                                    var f = number.toDouble()
                                    println("${number.toDouble()} ${if(1.0 == f) "degree Celsius" else "degrees Celsius"} is ${result} ${if(1.0 == result) "degree Celsius" else "degrees Celsius"}")
                                }
                                "fahrenheit" -> {
                                    result = number.toDouble()*9.0/5.0+32.0
                                    var f = number.toDouble()
                                    println("${number.toDouble()} ${if(1.0 == f) "degree Celsius" else "degrees Celsius"} is ${result} ${if(1.0 == result) "degree Fahrenheit" else "degrees Fahrenheit"}")
                                }
                                "kelvin" -> {
                                    result = number.toDouble()+273.15
                                    var f = number.toDouble()
                                    println("${number.toDouble()} ${if(1.0 == f) "degree Celsius" else "degrees Celsius"} is ${result} ${if(1.0 == result) "Kelvin" else "Kelvins"}")
                                }
                            }
                        }
                        "fahrenheit" -> {
                            when(getName(toMeas.toLowerCase(),true).toLowerCase()){
                                "celsius" -> {
                                    result = (number.toDouble()-32.0)*5.0/9.0
                                    var f = number.toDouble()
                                    println("${number.toDouble()} ${if(1.0 == f) "degree Fahrenheit" else "degrees Fahrenheit"} is ${result} ${if(1.0 == result) "degree Celsius" else "degrees Celsius"}")
                                }
                                "fahrenheit" -> {
                                    result = number.toDouble()*1.0
                                    var f = number.toDouble()
                                    println("${number.toDouble()} ${if(1.0 == f) "degree Fahrenheit" else "degrees Fahrenheit"} is ${result} ${if(1.0 == result) "degree Fahrenheit" else "degrees Fahrenheit"}")
                                }
                                "kelvin" -> {
                                    result = (number.toDouble()+459.67)*5.0/9.0
                                    var f = number.toDouble()
                                    println("${number.toDouble()} ${if(1.0 == f) "degree Fahrenheit" else "degrees Fahrenheit"} is ${result} ${if(1.0 == result) "Kelvin" else "Kelvins"}")
                                }
                            }
                        }
                        "kelvin" -> {
                            when(getName(toMeas.toLowerCase(),true).toLowerCase()){
                                "celsius" -> {
                                    result = number.toDouble()-273.15
                                    var f = number.toDouble()
                                    println("${number.toDouble()} ${if(1.0 == f) "Kelvin" else "Kelvins"} is ${result} ${if(1.0 == result) "degree Celsius" else "degrees Celsius"}")
                                }
                                "fahrenheit" -> {
                                    result = number.toDouble()*9.0/5.0-459.67
                                    var f = number.toDouble()
                                    println("${number.toDouble()} ${if(1.0 == f) "Kelvin" else "Kelvins"} is ${result} ${if(1.0 == result) "degree Fahrenheit" else "degrees Fahrenheit"}")
                                }
                                "kelvin" -> {
                                    result = number.toDouble()*1.0
                                    var f = number.toDouble()
                                    println("${number.toDouble()} ${if(1.0 == f) "Kelvin" else "Kelvins"} is ${result} ${if(1.0 == result) "Kelvin" else "Kelvins"}")
                                }
                            }
                        }
                    }
                }
            }
        }
        else{
            when(getName(fromMeas.toLowerCase(),false)){
                in listOf("Celsius", "Fahrenheit") -> {
                    print("Conversion from degrees ${getName(fromMeas.toLowerCase(),false)}")
                }
                else -> {
                    print("Conversion from ${getName(fromMeas.toLowerCase(),false)}")
                }
            }
            when(getName(toMeas.toLowerCase(),false)){
                in listOf("Celsius", "Fahrenheit") -> {
                    println(" to degrees ${getName(toMeas.toLowerCase(),false)} is impossible")
                }
                else -> {
                    println(" to ${getName(toMeas.toLowerCase(),false)} is impossible")
                }
            }
        }
    }
}
