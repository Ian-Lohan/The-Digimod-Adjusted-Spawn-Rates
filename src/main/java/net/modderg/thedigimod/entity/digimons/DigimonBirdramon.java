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

public class DigimonBirdramon extends CustomDigimon {

    public DigimonBirdramon(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
        this.switchNavigation(0);
    }

    public static AttributeSupplier.Builder setCustomAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 1D)
                .add(Attributes.FLYING_SPEED, 0.15D);
    }

    @Override
    public String evoStage() {
        return "champion";
    }

    @Override
    public String getSpecies() {
        return "Birdramon";
    }
    @Override
    protected RegistryObject<?>[] reincarnateTo(){
        return new RegistryObject[]{DigiItems.NYOKIMON};
    }
    @Override
    protected RegistryObject<?> xpDrop() {
        return DigiItems.WIND_DATA;
    }

    @Override
    protected String idleAnim() {
        return "idle7";
    }
    @Override
    protected String walkAnim() {
        return "walk9";
    }
    @Override
    protected String sitAnim() {
        return "sit4";
    }
    @Override
    protected String flyAnim() {
        return "fly";
    }
    @Override
    protected String attackAnim() {
        return "attack6";
    }

    @Override
    protected Boolean isFlyingDigimon() {
        return true;
    }

    @Override
    public EntityType digitronEvo() {
        return DigitalEntities.SABERDRAMON.get();
    }
}
