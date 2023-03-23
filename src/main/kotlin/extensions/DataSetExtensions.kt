package extensions

import model.DataSet

fun DataSet.getColumnPrefix(): String = this.toString().lowercase() + "_"