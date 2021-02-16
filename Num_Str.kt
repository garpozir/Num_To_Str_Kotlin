//برنامه تبدیل عدد به حروف با زبان کاتلین
//سازنده: بهروز غلامی اشرف
//Gmail: garpozir@gmail.com
//github: garpozir
//تشکر از جناب نور_کام انجمن بیلدر مجیدآنلاین

fun main() {
	print("Adad_Vared_Konid:\t");
	var adad: Long = readLine()!!.toLong();
	if (adad.toString().length > 12 || adad < 0) {
		print("Adad_Bozorg_Ya_Koochak!!!");
		return;
	}
	if (adad.toInt() == 0) {
		print("صفر");
		return;
	}
	var Yekan = arrayOf("يک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه");
	var Dah = arrayOf("ده", "يازده", "دوازده", "سيزده", "چهارده", "پانزده", "شانزده", "هفده", "هجده", "نوزده");
	var Dahgan = arrayOf("بيست", "سي", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود");
	var Sadgan = arrayOf("يکصد", "دويست", "سيصد", "چهارصد", "پانصد", "ششصد", "هفتصد", "هشتصد", "نهصد");
	var UnitArray = arrayOf(" هيچ ", " هزار ", " ميليون ", " ميليارد ");
	var And: String = " و ";
	if (adad < 10) {
		print(Yekan[adad.toInt() - 1]);
		return;
	}
	if (adad.toString().length == 2) {
		var num1 = (adad.toString().subSequence(0, 1)).toString();
		var num2 = (adad.toString().subSequence(1, 2)).toString();
		if (num1 == "1") {
			print(Dah[num2.toInt()]);
			return;
		}
		if (num2 == "0")
			print(Dahgan[num1.toInt() - 2]);
		else
			print(Dahgan[num1.toInt() - 2] + And + Yekan[num2.toInt() - 1]);
		return;
	}
	if (adad.toString().length > 2 && adad.toString().length < 13) {
		var piv: Int = (adad.toString().length) / 3;
		if ((piv.toString()) + ".0" != ((adad.toString().length) / 3f).toString()) piv++;
		var part: String;
		var besh: Int = 0;
		var num: String;
		var mum1: String;
		var mum2: String;
		var mum3: String;
		var Digit1: String;
		var Digit2: String;
		var text = arrayOf("");
		var Index: Int;
		for (i in 1..piv) {
			if (i == piv) {
				Index = (adad.toString().length) - ((i - 1) * 3);
				part = (adad.toString().subSequence(0, Index)).toString();
			} else {
				Index = ((adad.toString().length) - (i * 3)) + 1;
				part = (adad.toString().subSequence(Index - 1, adad.toString().length - besh)).toString(); besh += 3;
			}
			for (x in 1..3) {
				num = part.substring(0, 1);
				if (num == "0") part = part.replaceRange(0, 1, "");
				else break;
			}
			if (part.length == 0) text += " ";
			if (part.length == 3) {
				mum1 = part.subSequence(0, 1).toString();
				mum2 = part.subSequence(1, 2).toString();
				mum3 = part.subSequence(2, 3).toString();
				Digit1 = Sadgan[mum1.toInt() - 1];
				if (mum2 == "1") Digit2 = Dah[mum3.toInt()];
				else {
					if (mum2 != "0") {
						if (mum3 == "0") Digit2 = Dahgan[mum2.toInt() - 2];
						else Digit2 = (Dahgan[mum2.toInt() - 2]) + And + (Yekan[mum3.toInt() - 1]);
					} else {
						if (mum3 == "0") Digit2 = "";
						else Digit2 = Yekan[mum3.toInt() - 1];
					}
				}
				if (Digit2 == "") text += Digit1;
				else text += Digit1 + And + Digit2;
			}
			if (part.length == 2) {
				mum1 = part.subSequence(0, 1).toString();
				mum2 = part.subSequence(1, 2).toString();
				if (mum1 == "1") text += Dah[mum2.toInt()];
				else {
					if (mum2 == "0") text += Dahgan[mum1.toInt() - 2];
					else text += (Dahgan[mum1.toInt() - 2]) + And + (Yekan[mum2.toInt() - 1]);
				}
			}
			if (part.length == 1) {
				mum1 = part.subSequence(0, 1).toString();
				text += Yekan[mum1.toInt() - 1];
			}
		}
		var result: String = "";
		var unit: String;
		for (i in piv downTo 1) {
			unit = UnitArray[i - 1];
			if (text[i] != "" && text[i] != " ") {
				if (i == piv) result += text[i] + unit;
				else result += And + text[i] + unit;
			}
		}
		print(result.replace("هيچ", ""));
	} else return;
}