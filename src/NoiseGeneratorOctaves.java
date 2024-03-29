// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            NoiseGenerator, NoiseGeneratorPerlin, MathHelper

public class NoiseGeneratorOctaves extends NoiseGenerator
{

    public NoiseGeneratorOctaves(Random random, int i)
    {
        field_1191_b = i;
        generatorCollection = new NoiseGeneratorPerlin[i];
        for(int j = 0; j < i; j++)
        {
            generatorCollection[j] = new NoiseGeneratorPerlin(random);
        }

    }

    public double func_806_a(double d, double d1)
    {
        double d2 = 0.0D;
        double d3 = 1.0D;
        for(int i = 0; i < field_1191_b; i++)
        {
            d2 += generatorCollection[i].func_801_a(d * d3, d1 * d3) / d3;
            d3 /= 2D;
        }

        return d2;
    }

    public double[] generateNoiseOctaves(double ad[], int i, int j, int k, int l, int i1, int j1, 
            double d, double d1, double d2)
    {
        if(ad == null)
        {
            ad = new double[l * i1 * j1];
        } else
        {
            for(int k1 = 0; k1 < ad.length; k1++)
            {
                ad[k1] = 0.0D;
            }

        }
        double d3 = 1.0D;
        for(int l1 = 0; l1 < field_1191_b; l1++)
        {
            double d4 = (double)i * d3 * d;
            double d5 = (double)j * d3 * d1;
            double d6 = (double)k * d3 * d2;
            long l2 = MathHelper.floor_double_long(d4);
            long l3 = MathHelper.floor_double_long(d6);
            d4 -= l2;
            d6 -= l3;
            l2 %= 0x1000000L;
            l3 %= 0x1000000L;
            d4 += l2;
            d6 += l3;
            generatorCollection[l1].func_805_a(ad, d4, d5, d6, l, i1, j1, d * d3, d1 * d3, d2 * d3, d3);
            d3 /= 2D;
        }

        return ad;
    }

    public double[] func_4109_a(double ad[], int i, int j, int k, int l, double d, 
            double d1, double d2)
    {
        return generateNoiseOctaves(ad, i, 10, j, k, 1, l, d, 1.0D, d1);
    }

    private NoiseGeneratorPerlin generatorCollection[];
    private int field_1191_b;
}
