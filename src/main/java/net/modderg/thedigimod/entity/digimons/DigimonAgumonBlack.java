package net.modderg.thedigimod.entity.digimons;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.modderg.thedigimod.entity.CustomDigimon;
import net.modderg.thedigimod.entity.DigitalEntities;

public class DigimonAgumonBlack extends CustomDigimon {

    public DigimonAgumonBlack(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
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
    public Boolean isRookie() {
        return true;
    }

    @Override
    public String getSpecies() {
        return "Agumon(Black)";
    }
    @Override
    protected String IDLEANIM() {
        return "idle";
    }
    @Override
    protected String WALKANIM() {
        return "walk";
    }
    @Override
    protected String SITANIM() {
        return "sit";
    }

    @Override
    protected EntityType evoPath() {
        return DigitalEntities.DARKTYLIZZARDMON.get();
    }
    @Override
    protected Boolean canEvoToPath() {
        return true;
    }

    @Override
    protected EntityType evoPath3() {
        return DigitalEntities.GROWLMON.get();
    }
    @Override
    protected Boolean canEvoToPath3() {
        return this.getMood().equals("Joyful") && this.getSpecificXps(0) >= 50;
    }

    @Override
    protected EntityType evoPath4() {
        return DigitalEntities.GREYMONVIRUS.get();
    }
    @Override
    protected Boolean canEvoToPath4() {
        return this.getMood().equals("Joyful") && this.getSpecificXps(7) >= 25 && this.getSpecificXps(0) >= 25;
    }

    @Override
    protected EntityType evoPath5() {
        return DigitalEntities.DARKTYRANNOMON.get();
    }
    @Override
    protected Boolean canEvoToPath5() {
        return this.getMood().equals("Joyful") && this.getSpecificXps(7) >= 50;
    }
}
