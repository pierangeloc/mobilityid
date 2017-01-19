package com.thenewmotion.mobilityid

import org.specs2.mutable.Specification
import interpolators._

class InterpolatorsSpec extends Specification {

  "EmaId" should {
    "be creatable with interpolator" in {
      emaId"NL-TNM-000722345-X" mustEqual EmaId("NL", "TNM", "000722345")
    }

    "be creatable with interpolator" in {
      emaId"NLTNM000722345X" mustEqual EmaId("NL", "TNM", "000722345")
    }
  }

  "EvseId" should {
    "be creatable with interpolator" in {
      evseId"NL*TNM*E840*6487" mustEqual EvseId("NL", "TNM", "840*6487")
    }

    "be creatable with interpolator (iso format)" in {
      evseIdIso"NL*TNM*E840*6487" mustEqual EvseIdIso("NL", "TNM", "840*6487")
    }

    "be creatable with interpolator (din format)" in {
      evseIdDin"+49*810*000*438" mustEqual EvseIdDin("+49", "810", "000*438")
    }

    "be creatable with interpolators of component parts (iso format)" in {
      EvseIdIso(countryCode"NL", operatorIdIso"TNM", "840*6487") mustEqual EvseIdIso("NL", "TNM", "840*6487")
    }

    "be creatable with interpolators of component parts (din format)" in {
      EvseIdDin(phoneCountryCode"+31", operatorIdDin"365", "840*6487") mustEqual EvseIdDin("+31", "365", "840*6487")
    }

  }

  "providerId" should {
    "be creatable with interpolator" in {
      providerId"ABC" mustEqual ProviderId("ABC")
    }
  }

  "country code" should {
    "be creatable with interpolator" in {
      countryCode"NL" mustEqual CountryCode("NL")
    }
  }

  "phone country code" should {
    "be creatable with interpolator" in {
      phoneCountryCode"+31" mustEqual PhoneCountryCode("+31")
    }
  }

  "operatorIdIso" should {
    "be creatable with interpolator" in {
      operatorIdIso"TNM" mustEqual OperatorIdIso("TNM")
    }
  }

  "operatorIdDin" should {
    "be creatable with interpolator" in {
      operatorIdDin"456" mustEqual OperatorIdDin("456")
    }
  }
}
