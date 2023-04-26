package net.modderg.thedigimod.entity.digimons;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import net.modderg.thedigimod.entity.CustomDigimon;
import net.modderg.thedigimod.entity.DigitalEntities;
import net.modderg.thedigimod.item.DigiItems;

public class DigimonMochimonK extends CustomDigimon {

    public DigimonMochimonK(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
        this.switchNavigation(0);
    }

    public static AttributeSupplier.Builder setCustomAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 1D)
                .add(Attributes.FLYING_SPEED, 0.3D);
    }

    @Override
    public Boolean isBaby2() {
        return true;
    }

    @Override
    public String getSpecies() {
        return "Mochimon";
    }
    @Override
    protected RegistryObject<?>[] reincarnateTo(){
        return new RegistryObject[]{DigiItems.BUBBMONK};
    }

    @Override
    protected String idleAnim() {
        return "idle3";
    }
    @Override
    protected String walkAnim() {
        return "walk3";
    }
    @Override
    protected String sitAnim() {
        return "sit2";
    }

    @Override
    protected EntityType evoPath() {
        return DigitalEntities.KUNEMON.get();
    }
    @Override
    protected Boolean canEvoToPath() {
        return true;
    }
}
