/**
 *
 */
package com.example.hero.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lepra
 *
 */
@Service
public class HeroImpl implements Hero {

  @Autowired
  private com.example.hero.mapper.HeroMapper heroMapper;

  /* (非 Javadoc)
   * @see com.example.hero.service.Hero#getHeroList()
   */
  @Override
  public List<com.example.hero.model.entity.Hero> getHeroList() {
    return heroMapper.selectHeroList();
  }

  /* (非 Javadoc)
   * @see com.example.hero.service.Hero#getHero(com.example.hero.model.entity.Hero)
   */
  @Override
  public List<com.example.hero.model.entity.Hero> getHero(com.example.hero.model.entity.Hero hero) {
    if(Objects.nonNull(hero.getId())) {
      return Arrays.asList(heroMapper.selectHeroById(hero.getId()));
    } else {
      return heroMapper.selectHeroByName(hero.getName());
    }
  }

  /* (非 Javadoc)
   * @see com.example.hero.service.Hero#addHero(com.example.hero.model.entity.Hero)
   */
  @Override
  public Boolean addHero(com.example.hero.model.entity.Hero hero) {
    return heroMapper.insertHero(hero);
  }

  /* (非 Javadoc)
   * @see com.example.hero.service.Hero#removeHeroName(java.lang.Integer)
   */
  @Override
  public Boolean removeHeroName(Integer id) {
    return heroMapper.deleteHeroById(id);
  }

  /* (非 Javadoc)
   * @see com.example.hero.service.Hero#setHeroName(com.example.hero.model.entity.Hero)
   */
  @Override
  public Boolean setHeroName(com.example.hero.model.entity.Hero hero) {
    return heroMapper.deleteHero(hero);
  }

}
