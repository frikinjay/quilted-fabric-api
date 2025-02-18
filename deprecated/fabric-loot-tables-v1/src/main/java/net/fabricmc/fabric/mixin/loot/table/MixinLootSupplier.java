/*
 * Copyright 2016, 2017, 2018, 2019 FabricMC
 * Copyright 2022 QuiltMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.fabric.mixin.loot.table;

import java.util.List;

import com.google.common.collect.ImmutableList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.function.LootFunction;

import net.fabricmc.fabric.api.loot.v1.FabricLootSupplier;

@Mixin(LootTable.class)
public abstract class MixinLootSupplier implements FabricLootSupplier {
	@Shadow
	@Final
	LootPool[] pools;

	@Shadow
	@Final
	LootFunction[] functions;

	@Override
	public List<LootPool> getPools() {
		return ImmutableList.copyOf(pools);
	}

	@Override
	public List<LootFunction> getFunctions() {
		return ImmutableList.copyOf(functions);
	}
}
