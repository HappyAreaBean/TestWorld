package cc.happyareabean.testworld.enums;

import cc.happyareabean.testworld.Utils;
import lombok.Getter;

public enum ImanitySpigotConfig {
	ASYNC_CHUNK_LOADS("asyncChunkLoads", Utils.getImanitySpigotConfig().getBoolean("asyncChunkLoads.enabled")),
	ASYNC_CHUNK_GENERATION("asyncChunkGeneration", Utils.getImanitySpigotConfig().getBoolean("asyncChunkLoads.asyncChunkGeneration"));

	@Getter private String configName;
	@Getter private boolean currentStatus;
	ImanitySpigotConfig(String configName, Boolean currentStatus) {
		this.configName = configName;
		this.currentStatus = currentStatus;
	}
}
