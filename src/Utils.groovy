class Utils {
    static def getDataInDoubleFormat (def data) {
        try {
            return Double.parseDouble(data)
        } catch (Exception err) {
            throw new Exception("Invalid data: ${data}, Can't ${data} to Double.")
        }
    }

    static def getDataInIntegerFormat (def data) {
        try {
            return Integer.parseInt(data)
        } catch (Exception err) {
            throw new Exception("Invalid data: ${data}, Can't ${data} to Integer.")
        }
    }
}
