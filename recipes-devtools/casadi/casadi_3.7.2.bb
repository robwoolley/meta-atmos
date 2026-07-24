LICENSE = "DSDP & LGPL-2.1-only & LGPL-3.0-only & Zlib & BSD-2-Clause & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e6a600fd5e1d9cbde2d983680233ad02 \
                    file://external_packages/CSparse/Doc/License.txt;md5=3711500fd6c51f4decf7f30082ff1dfd \
                    file://external_packages/DSDP/dsdp-license;md5=ef29c0513373a489942beaff1fcc9e68 \
                    file://external_packages/FMI-Standard-2.0.2/LICENSE.txt;md5=3a30bc9db7764b7c5357c93073f8249e \
                    file://external_packages/FMI-Standard-3.0/LICENSE.txt;md5=670421012d676551b85301632cf72491 \
                    file://external_packages/casadi-sundials/LICENSE;md5=5ff4d0857012f81b7b9ae931c82bea8d \
                    file://external_packages/casadi-sundials/cvodes/LICENSE;md5=16a7b2968fa2c357f8270812ca01cd99 \
                    file://external_packages/casadi-sundials/idas/LICENSE;md5=2971bf0a290344bc768e4391eadf56a7 \
                    file://external_packages/casadi-sundials/kinsol/LICENSE;md5=315fb3db4828c7ca21ca44ff4e38c785 \
                    file://external_packages/casadi-sundials/sundials/LICENSE;md5=97da656f54f15c75f11d114875f6b642 \
                    file://external_packages/qpOASES/LICENSE.txt;md5=10c499b8639e393a2e7351abf44a1108 \
                    file://external_packages/tinyxml2-9.0.0/LICENSE.txt;md5=135624eef03e1f1101b9ba9ac9b5fffd \
                    file://misc/license_header.txt;md5=d136f77474d480bdc20f110d87b1569b \
                    file://misc/license_header_octave.txt;md5=648f89652b0c7c0a0ef1f8b9dbca6190 \
                    file://misc/license_header_python.txt;md5=a2fe38699c84caa7a09ccb8efbf2fc05 \
                    file://misc/update_license.py;md5=c7e13cbf6136e9361bd36011f71ad6c3 \
                    file://misc/update_license_python.py;md5=0b4fb89e9e5950ab559dd83d1b43230c"

SRC_URI = "gitsm://github.com/casadi/casadi;protocol=https;branch=main"

PV = "3.7.2+git"
SRCREV = "f959d3175a444d763e4eda4aece48f4c5f4a6f90"

DEPENDS = "zlib swig-native"

inherit cmake python3-dir python3native

do_configure:append() {
        sed -i -e 's,--sysroot=${STAGING_DIR_TARGET},,g' \
            -e 's,--canon-prefix-map,,g' \
            -e 's,-ffile-prefix-map=${S}=${TARGET_DBGSRC_DIR},,g' \
            -e 's,-ffile-prefix-map=${B}=${TARGET_DBGSRC_DIR},,g' \
            -e 's,-ffile-prefix-map=${STAGING_DIR_HOST}=,,g' \
            -e 's,-ffile-prefix-map=${STAGING_DIR_NATIVE}=,,g' \
            ${B}/casadi/config.h
}
