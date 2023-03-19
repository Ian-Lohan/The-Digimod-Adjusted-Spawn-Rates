package net.modderg.thedigimod.entity.digimons;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.modderg.thedigimod.entity.CustomDigimon;
import net.modderg.thedigimod.entity.DigitalEntities;

public class DigimonPuyoyomon extends CustomDigimon {

    public DigimonPuyoyomon(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
        this.switchNavigation(0);
    }

    public static AttributeSupplier.Builder setCustomAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 15.0D)
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
        return "Puyoyomon";
    }
    @Override
    protected String IDLEANIM() {
        return "idle3";
    }
    @Override
    protected String WALKANIM() {
        return "walk4";
    }
    @Override
    protected String SITANIM() {
        return "sit2";
    }

    @Override
    protected EntityType evoPath() {
        return DigitalEntities.JELLYMON.get();
    }
    @Override
    protected Boolean canEvoToPath() {
        return true;
    }
}
