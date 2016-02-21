$(call inherit-product, $(SRC_TARGET_DIR)/product/languages_full.mk)

$(call inherit-product-if-exists, vendor/xiaomi/libra/libra-vendor.mk)

DEVICE_PACKAGE_OVERLAYS += device/xiaomi/libra/overlay

TARGET_OTA_ASSERT_DEVICE := 4C,libra

$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/aosp_base_telephony.mk)
$(call inherit-product, frameworks/native/build/phone-xhdpi-2048-dalvik-heap.mk)

PRODUCT_COPY_FILES += \
    device/xiaomi/libra/kernel:kernel

# Bson
PRODUCT_PACKAGES += \
    libbson

# Curl
PRODUCT_PACKAGES += \
    libcurl \
    curl

# Filesystem management tools
PRODUCT_PACKAGES += \
    e2fsck \
    make_ext4fs \
    setup_fs

PRODUCT_PACKAGES += \
    libqmi_cci \
    libqmi_common_so \
    libqmiservices \
    libqminvapi \
    libqmi_client_qmux \
    libqmi_encdec \
    libsmemlog \
    libidl \
    libdsutils \
    libdiag

# Lights
PRODUCT_PACKAGES += \
    lights.msm8992

# Power
PRODUCT_PACKAGES += \
    power.qcom

# USB
PRODUCT_PACKAGES += \
    com.android.future.usb.accessory

# Screen density
PRODUCT_AAPT_CONFIG := normal
PRODUCT_AAPT_PREF_CONFIG := xxhdpi


PRODUCT_NAME := full_libra
PRODUCT_DEVICE := libra
PRODUCT_MANUFACTURER := Xiaomi
PRODUCT_MODEL := Mi-4c

