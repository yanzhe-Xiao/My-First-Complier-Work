/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from GenCode.idl using "idltoc".
The idltoc tool is part of the RTI Data Distribution Service distribution.
For more information, type 'idltoc -help' at a command shell
or consult the RTI Data Distribution Service manual.
*/
#ifndef GenCode_h
#define GenCode_h

#ifndef rti_me_cpp_hxx
#include "rti_me_cpp.hxx"
#endif

#ifdef NDDS_USER_DLL_EXPORT
#if (defined(RTI_WIN32) || defined(RTI_WINCE))
/* If the code is building on Windows, start exporting symbols. */
#undef NDDSUSERDllExport
#define NDDSUSERDllExport __declspec(dllexport)
#endif
#else
#undef NDDSUSERDllExport
#define NDDSUSERDllExport
#endif

struct space_space1_ASeq;
class space_space1_ATypeSupport;
class space_space1_ADataWriter;
class space_space1_ADataReader;

class space_space1_A
{
public:
    typedef struct space_space1_ASeq Seq;
    typedef space_space1_ATypeSupport TypeSupport;
    typedef space_space1_ADataWriter DataWriter;
    typedef space_space1_ADataReader DataReader;

        CDR_Short a = 10;

};

extern const char *space_space1_ATYPENAME;

REDA_DEFINE_SEQUENCE_STRUCT(space_space1_ASeq, space_space1_A);

REDA_DEFINE_SEQUENCE_IN_C(space_space1_ASeq, space_space1_A);

NDDSUSERDllExport extern RTI_BOOL
space_space1_A_initialize(space_space1_A *sample)
{
    CDR_Primitive_init_Short(&sample->a);

    return RTI_TRUE;
}

NDDSUSERDllExport extern RTI_BOOL
space_space1_A_finalize(space_space1_A *sample)
{
    UNUSED_ARG(sample);
    return RTI_TRUE;
}


struct space_space2_BSeq;
class space_space2_BTypeSupport;
class space_space2_BDataWriter;
class space_space2_BDataReader;

class space_space2_B
{
public:
    typedef struct space_space2_BSeq Seq;
    typedef space_space2_BTypeSupport TypeSupport;
    typedef space_space2_BDataWriter DataWriter;
    typedef space_space2_BDataReader DataReader;

        CDR_Long c = 100;

};

extern const char *space_space2_BTYPENAME;

REDA_DEFINE_SEQUENCE_STRUCT(space_space2_BSeq, space_space2_B);

REDA_DEFINE_SEQUENCE_IN_C(space_space2_BSeq, space_space2_B);

NDDSUSERDllExport extern RTI_BOOL
space_space2_B_initialize(space_space2_B *sample)
{
    CDR_Primitive_init_Long(&sample->c);

    return RTI_TRUE;
}

NDDSUSERDllExport extern RTI_BOOL
space_space2_B_finalize(space_space2_B *sample)
{
    UNUSED_ARG(sample);
    return RTI_TRUE;
}

#ifdef NDDS_USER_DLL_EXPORT
#if (defined(RTI_WIN32) || defined(RTI_WINCE))
/* If the code is building on Windows, stop exporting symbols. */
#undef NDDSUSERDllExport
#define NDDSUSERDllExport
#endif
#endif

#endif /* hxx */
