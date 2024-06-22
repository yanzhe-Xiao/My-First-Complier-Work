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

struct space_ASeq;
class space_ATypeSupport;
class space_ADataWriter;
class space_ADataReader;

class space_A
{
public:
    typedef struct space_ASeq Seq;
    typedef space_ATypeSupport TypeSupport;
    typedef space_ADataWriter DataWriter;
    typedef space_ADataReader DataReader;

        CDR_Short i1 = 10;
        CDR_Short i2 = 10;
        CDR_Long i3 = 100;
        CDR_Long i4 = 100;
        CDR_Longlong i5 = 1000;
        CDR_LongLong i6 = 1000;
        CDR_Unsignedshort i7 = 10;
        CDR_UnsignedShort i8 = 10;
        CDR_Unsignedlong i9 = 100;
        CDR_Short arr[10] = {};
        CDR_Short arr[0] = {};
        CDR_Short arr[1] = {};
        CDR_Short arr[2] = {};
        CDR_Short arr[3] = {};
        CDR_Short arr[4] = {};
        CDR_Short arr[5] = {};
        CDR_Short arr[6] = {};
        CDR_Short arr[7] = {};
        CDR_Short arr[8] = {};
        CDR_Short arr[9] = {};
        CDR_Char c0 = 'a';
        CDR_String c1 = "abc";
        CDR_Boolean c2 = true;
        CDR_Float c3 = 10.901f;
        CDR_Double c4 = 23.234d;
        CDR_Longdouble c5 = 12.23456432235d;
        CDR_UnsignedLong i10 = 100;
        CDR_Unsignedlonglong i11 = 1000;
        CDR_UnsignedLongLong i12 = 1000;

};

extern const char *space_ATYPENAME;

REDA_DEFINE_SEQUENCE_STRUCT(space_ASeq, space_A);

REDA_DEFINE_SEQUENCE_IN_C(space_ASeq, space_A);

NDDSUSERDllExport extern RTI_BOOL
space_A_initialize(space_A *sample)
{
    CDR_Primitive_init_Short(&sample->i1);
    CDR_Primitive_init_Short(&sample->i2);
    CDR_Primitive_init_Long(&sample->i3);
    CDR_Primitive_init_Long(&sample->i4);
    CDR_Primitive_init_Longlong(&sample->i5);
    CDR_Primitive_init_LongLong(&sample->i6);
    CDR_Primitive_init_Unsignedshort(&sample->i7);
    CDR_Primitive_init_UnsignedShort(&sample->i8);
    CDR_Primitive_init_Unsignedlong(&sample->i9);

        CDR_Primitive_init_Array(
                sample->arr, ((10) * CDR_SHORT_SIZE));

        CDR_Primitive_init_Array(
                sample->arr, ((0) * CDR_SHORT_SIZE));

        CDR_Primitive_init_Array(
                sample->arr, ((1) * CDR_SHORT_SIZE));

        CDR_Primitive_init_Array(
                sample->arr, ((2) * CDR_SHORT_SIZE));

        CDR_Primitive_init_Array(
                sample->arr, ((3) * CDR_SHORT_SIZE));

        CDR_Primitive_init_Array(
                sample->arr, ((4) * CDR_SHORT_SIZE));

        CDR_Primitive_init_Array(
                sample->arr, ((5) * CDR_SHORT_SIZE));

        CDR_Primitive_init_Array(
                sample->arr, ((6) * CDR_SHORT_SIZE));

        CDR_Primitive_init_Array(
                sample->arr, ((7) * CDR_SHORT_SIZE));

        CDR_Primitive_init_Array(
                sample->arr, ((8) * CDR_SHORT_SIZE));

        CDR_Primitive_init_Array(
                sample->arr, ((9) * CDR_SHORT_SIZE));

    CDR_Primitive_init_Char(&sample->c0);

        if (!CDR_String_initialize(&sample->c1, (255)))
        {
            return RTI_FALSE;
        }

    CDR_Primitive_init_Boolean(&sample->c2);
    CDR_Primitive_init_Float(&sample->c3);
    CDR_Primitive_init_Double(&sample->c4);
    CDR_Primitive_init_Longdouble(&sample->c5);
    CDR_Primitive_init_UnsignedLong(&sample->i10);
    CDR_Primitive_init_Unsignedlonglong(&sample->i11);
    CDR_Primitive_init_UnsignedLongLong(&sample->i12);

    return RTI_TRUE;
}

NDDSUSERDllExport extern RTI_BOOL
space_A_finalize(space_A *sample)
{
    UNUSED_ARG(sample);
        {
                RTI_UINT32 i;

                for (i = 0; i < (10); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }

        {
                RTI_UINT32 i;

                for (i = 0; i < (0); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }

        {
                RTI_UINT32 i;

                for (i = 0; i < (1); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }

        {
                RTI_UINT32 i;

                for (i = 0; i < (2); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }

        {
                RTI_UINT32 i;

                for (i = 0; i < (3); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }

        {
                RTI_UINT32 i;

                for (i = 0; i < (4); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }

        {
                RTI_UINT32 i;

                for (i = 0; i < (5); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }

        {
                RTI_UINT32 i;

                for (i = 0; i < (6); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }

        {
                RTI_UINT32 i;

                for (i = 0; i < (7); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }

        {
                RTI_UINT32 i;

                for (i = 0; i < (8); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }

        {
                RTI_UINT32 i;

                for (i = 0; i < (9); i++)
                {
                    if (!CDR_Short_copy(&dst->arr[i],
                                        &src->arr[i]))
                    {
                        return RTI_FALSE;
                    }
                }
        }


        CDR_String_finalize(&sample->c1);








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
