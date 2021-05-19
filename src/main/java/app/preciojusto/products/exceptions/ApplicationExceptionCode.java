package app.preciojusto.products.exceptions;

import lombok.Getter;

public enum ApplicationExceptionCode {
    UNKNOWN_ERROR(-1),
    BADREQUEST_ERROR(-2),
    UNAUTHORIZED_ERROR(-3),
    BADGATEWAY_ERROR(-4),

    NOT_FOUND_ERROR(0),
    BRAND_NOT_FOUND_ERROR(1),
    CATEGORY_NOT_FOUND_ERROR(2),
    PACK_NOT_FOUND_ERROR(3),
    RECIPE_NOT_FOUND_ERROR(4),
    SUPERMARKET_NOT_FOUND_ERROR(5),
    CONTAINER_NOT_FOUND_ERROR(6),
    SUPERMARKETPRODUCT_NOT_FOUND_ERROR(7),
    PRODUCT_NOT_FOUND_ERROR(8),
    FOODPRODUCT_NOT_FOUND_ERROR(9),
    OFFER_NOT_FOUND_ERROR(10),
    OFFERPERCENTAGE_NOT_FOUND_ERROR(11),
    OFFERUNIT_NOT_FOUND_ERROR(12),
    OFFERUNITPERCENTAGE_NOT_FOUND_ERROR(13),
    OFFERUNKNOWN_NOT_FOUND_ERROR(14),

    ALREADY_EXISTS_ERROR(100),
    BRAND_ALREADY_EXISTS_ERROR(101),
    CATEGORY_ALREADY_EXISTS_ERROR(102),
    PACK_ALREADY_EXISTS_ERROR(103),
    RECIPE_ALREADY_EXISTS_ERROR(104),
    SUPERMARKET_ALREADY_EXISTS_ERROR(105),
    CONTAINER_ALREADY_EXISTS_ERROR(106),
    SUPERMARKETPRODUCT_ALREADY_EXISTS_ERROR(107),
    PRODUCT_ALREADY_EXISTS_ERROR(108),
    FOODPRODUCT_ALREADY_EXISTS_ERROR(109),
    OFFER_ALREADY_EXISTS_ERROR(110),
    OFFERPERCENTAGE_ALREADY_EXISTS_ERROR(111),
    OFFERUNIT_ALREADY_EXISTS_ERROR(112),
    OFFERUNITPERCENTAGE_ALREADY_EXISTS_ERROR(113),
    OFFERUNKNOWN_ALREADY_EXISTS_ERROR(114),

    NO_CONTENT_ERROR(200),
    BRAND_NO_CONTENT_ERROR(201),
    CATEGORY_NO_CONTENT_ERROR(202),
    OFFER_NO_CONTENT_ERROR(203),
    PACK_NO_CONTENT_ERROR(204),
    RECIPE_NO_CONTENT_ERROR(205),
    SUPERMARKET_NO_CONTENT_ERROR(206),
    CONTAINER_NO_CONTENT_ERROR(207),
    SUPERMARKETPRODUCT_NO_CONTENT_ERROR(208),
    PRODUCT_NO_CONTENT_ERROR(209),
    FOODPRODUCT_NO_CONTENT_ERROR(210),
    OFFERPERCENTAGE_NO_CONTENT_ERROR(211),
    OFFERUNIT_NO_CONTENT_ERROR(212),
    OFFERUNITPERCENTAGE_NO_CONTENT_ERROR(213),
    OFFERUNKNOWN_NO_CONTENT_ERROR(214);

    @Getter
    private final int code;

    ApplicationExceptionCode(int code) {
        this.code = code;
    }
}
