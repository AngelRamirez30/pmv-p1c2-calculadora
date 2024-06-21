package com.example.pmv_p1u2_calculadora

class Calculadora (var num1:Float , var num2:Float) {
    public fun suma ():Float {
        return this.num1+num2
    }
    public fun resta() : Float {
        return this.num1-num2
    }
    public fun mult() : Float {
        return this.num2*num2
    }
    public fun div() : Float {
        if(this.num1!=0.0f && this.num2!=0.0f)
            return this.num1/num2
        else return 0.0f
    }
}