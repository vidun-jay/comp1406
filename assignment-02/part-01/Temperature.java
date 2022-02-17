/**
 * name: Vidun Jayakody
 * id: 101224988
 * course: COMP1406
 * semester: win22
 *
 * assignment: 2
 * comments
 */

public class Temperature {

  private double temp;
  private String scale;

/** Initializes a temperature object with given value in Celcius
 *  <par>
 *  If the initial temperature is less than -273.15C then the temperature
 *  object will be initialized with -273.15C.
 *
 * @param temp is the initial temperature in Celsius.
 */
  public Temperature(double temp) {

    this.scale = Scale.CELCIUS;

    if (temp <= -273.15)
      this.temp = -273.15;
    else
      this.temp = temp;

  }

/** Initializes a temperature object with given value using the specified scale
 * <par>
 * If the temperature is lower than absolute zero, in the given scale,
 * then set the temperature to absolute zero (in that scale).
 * <par>
 * If the scale is not one of the three specified in the Scale class,
 * then create the object with value 0.0 and scale Scale.NONE
 * <par>
 * Example: new Temperature(12.3, Scale.KELVIN)
 *
 * @param temp is the initial temperature
 * @param scale is the scale of initial temperature and must a constant
 *        defined in the Scale enum type.
 */
  public Temperature(double temp, String scale) {

    if (scale == Scale.CELCIUS) {
        // if temp is colder than absolute 0, make it absolute 0
        if (temp <= -273.15)
          this.temp = -273.15;
        else
          this.temp = temp;
        this.scale = Scale.CELCIUS;
    } else if (scale == Scale.FAHRENHEIT) {
        // if temp is colder than absolute 0, make it absolute 0
        if (temp <= -459.67)
          this.temp = -459.67;
        else
          this.temp = temp;
        this.scale = Scale.FAHRENHEIT;
    } else if (scale == Scale.KELVIN) {
        // if temp is colder than absolute 0, make it absolute 0
        if (temp <= 0)
          this.temp = 0;
        else
          this.temp = temp;
        this.scale = Scale.KELVIN;
    } else {
        this.temp = 0;
        this.scale = Scale.NONE;
    }
  }

/** getter for the scale.
 *  The output will always be one of the static attributes
 *  from the Scale class.
 *
 * @return the current scale of this object.
 */
  public String getScale() {
    return this.scale;
  }

 /** getter for the temperature value (in the current scale)
  *
  * @return the temperature of the object using the current scale
  */
  public double getValue() {
    return this.temp;
  }

  /** setter for scale
  * <par>
  * If the scale is not one of the three specified in the Scale class,
  * then set the to scale Scale.NONE and leave the value unchanged.
  *
  * @param scale is the new scale of the temperature and must be
  *        a constant from the Scale class.
  */
  public void setScale(String scale) {
    // from CELCIUS to FAHRENHEIT
    if (this.scale == Scale.CELCIUS && scale == Scale.FAHRENHEIT) {
      this.temp = (this.temp * 9/5) + 32;
      this.scale = scale;
    // from CELCIUS to KELVIN
    } else if (this.scale == Scale.CELCIUS && scale == Scale.KELVIN) {
      this.temp = this.temp + 273.15;
      this.scale = scale;

    // from FAHRENHEIT to CELCIUS
    } else if (this.scale == Scale.FAHRENHEIT && scale == Scale.CELCIUS) {
      this.temp = (this.temp - 32) * 5/9;
      this.scale = scale;
    // from FAHRENHEIT to KELVIN
    } else if (this.scale == Scale.FAHRENHEIT && scale == Scale.KELVIN) {
      this.temp = (this.temp + 459.67) * 5/9;
      this.scale = scale;

    // from KELVIN to CELCIUS
    } else if (this.scale == Scale.KELVIN && scale == Scale.CELCIUS) {
      this.temp = this.temp - 273.15;
      this.scale = scale;
    // from KELVIN to FAHRENHEIT
    } else if (this.scale == Scale.KELVIN && scale == Scale.FAHRENHEIT) {
      this.temp = (this.temp * 9/5) - 459.67;
      this.scale = scale;
    }
  }

  /** setter for value. It is assumed that this value is in the
   * object's current scale.
   * <p>
   * For example, if the current scale
   * is Scale.KELVIN, then obj.setValue(12.4) sets current
   * temperature to be 12.4K.
   * <p>
   * As usual, if the value is less than absolute zero, the
   * object's temperature is set to absolute zero in the
   * current scale.
   *
   * @param value is the new value of the temperature and must be
   */
  public void setValue(double value) {

    if (this.scale == Scale.CELCIUS) {
      if (this.temp <= -273.15)
        this.temp = -273.15;
      this.temp = value;
    } else if (this.scale == Scale.FAHRENHEIT) {
      if (this.temp <= -459.67)
        this.temp = -459.67;
      this.temp = value;
    } else if (this.scale == Scale.KELVIN) {
      if (this.temp <= 0)
        this.temp = 0;
      this.temp = value;
    }

  }

  /** setter for temperature
  * <par>
  * If the temperature is lower than absolute zero, in the given scale,
  * then sets the temperature to absolute zero (in that scale).
  * <par>
  * If the scale is not one of the three specified in the Scale class,
  * then set the object's value to be 0.0 and scale to be Scale.NONE
  *
  * @param temp is the new temperature
  * @param scale must be one of the class attributes from the Scale class
  */
  public void setTemp(double value, String scale) {

    if (this.scale == Scale.CELCIUS) {
      if (this.temp <= -273.15)
        this.temp = -273.15;
      this.temp = value;
    } else if (this.scale == Scale.FAHRENHEIT) {
      if (this.temp <= -459.67)
        this.temp = -459.67;
      this.temp = value;
    } else if (this.scale == Scale.KELVIN) {
      if (this.temp <= 0)
        this.temp = 0;
      this.temp = value;
    } else {
      this.temp = 0;
      this.scale = Scale.NONE;
    }

  }

/* ------------------------------------------------- */
/* ------------------------------------------------- */
/* do not change anything below this                 */
/* ------------------------------------------------- */
/* ------------------------------------------------- */

  /** String representation of a temperature object    */
  @Override
  public String toString(){
    return "" + this.getValue() + this.getScale().charAt(0);
  }
}
