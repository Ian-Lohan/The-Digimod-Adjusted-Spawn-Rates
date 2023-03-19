package net.modderg.thedigimod.entity.renders;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.modderg.thedigimod.entity.CustomDigimon;
import net.modderg.thedigimod.entity.CustomDigimonRender;
import net.modderg.thedigimod.entity.digimons.DigimonChakmon;
import net.modderg.thedigimod.entity.models.ChakmonModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChakmonRender extends CustomDigimonRender<DigimonChakmon> {

    public ChakmonRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, (AnimatedGeoModel<CustomDigimon>) new ChakmonModel());
    }
}

