package com.readoria.book_service.utils.barcode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class BarcodeID {

    public static String generateUniqueID(){
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String uuidPart = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8); // Take 8 characters of the UUID
        return "BK - " + timestamp + uuidPart;
    }
}
