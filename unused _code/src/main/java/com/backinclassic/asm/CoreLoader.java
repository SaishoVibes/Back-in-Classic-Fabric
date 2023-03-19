package com.backinclassic.asm;

import java.util.Map;

import com.backinclassic.asm.helper.ObfHelper;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name("Damage Tilt ASM")
@IFMLLoadingPlugin.SortingIndex(1002)
@IFMLLoadingPlugin.TransformerExclusions({ "com.backinclassic.asm", "com.backinclassic.asm." })

public class CoreLoader implements IFMLLoadingPlugin
{
	//
	// IFMLLoadingPlugin
	// 

	@Override
	public String[] getASMTransformerClass()
	{
		return new String[] { "com.backinclassic.asm.DamageTiltASM" };
	}

	@Override
	public void injectData(Map<String, Object> data)
	{
		ObfHelper.setObfuscated((Boolean) data.get("runtimeDeobfuscationEnabled"));
		ObfHelper.setRunsAfterDeobfRemapper(true);
	}

	@Override
	public String getModContainerClass()
	{
		return null;
	}

	@Override
	public String getSetupClass()
	{
		return null;
	}

	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}
}
